package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import beans.LearningFile;
import control.LearningFileManager;
import dao.LearningFileDAO;

public class UploadFileStudentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession(true);
		String studentId = (String) session.getAttribute("studentId");
		//String studentName = (String) session.getAttribute("studentName");
		int lessonId = (int) session.getAttribute("lessonId");

		// (1)アップロードファイルを格納するPATHを取得(OSによって変化する)
		// String path =
		// ("C:/Users/J14-8002/pleiades/workspace/snap/WebContent/Public/LearningFile");
		// String path = ("/usr/share/tomcat/webapps/snap/Public/LearningFile");
		String path = ("/Applications/Eclipse_4.6.3.app/Contents/workspace/snap/WebContent/Public/LearningFile");

		// (2)ServletFileUploadオブジェクトを生成
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

		// (3)アップロードする際の基準値を設定
		factory.setSizeThreshold(2048);
		upload.setSizeMax(-1);
		upload.setHeaderEncoding("UTF-8");
		try {

			// (4)ファイルデータ(FileItemオブジェクト)を取得し、
			List<FileItem> list = upload.parseRequest(request);

			// (5)ファイルデータ(FileItemオブジェクト)を順に処理
			Iterator<FileItem> iterator = list.iterator();
			while (iterator.hasNext()) {
				FileItem fItem = (FileItem) iterator.next();

				// (6)ファイルデータの場合、if内を実行
				if (!(fItem.isFormField())) {

					// (7)ファイルデータのファイル名(PATH名含む)を取得
					String fileName = fItem.getName();

					// (7')ファイル名で空白があった場合は正規表現により_に変更する
					LearningFileManager fileManager = new LearningFileManager();
					fileName = fileManager.checkSpace(fileName);
					fileName = fileManager.updateFileName(fileName);
					request.setAttribute("fileName", fileName);

					if ((fileName != null) && (!fileName.equals(""))) {
						// (8)PATH名を除くファイル名のみを取得
						fileName = (new File(fileName)).getName();

						// (9)ファイルデータを指定されたファイルに書き出し
						fItem.write(new File(path + "/" + studentId + "/" + lessonId + "/" + fileName));

						// (10)送信された学習記録データのフィルの拡張子を確認
						// .PNG == 1 .mp4 == 2
						int kind = fileManager.IdentifyFileKind(fileName);

						// (11)学習記録データの登録情報をDBに登録
						LearningFileDAO fileDAO = new LearningFileDAO();
						fileDAO.uploadFile(path, studentId, lessonId, fileName, kind);
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * studentIdとlessonIdで学習記録データをDBから引っ張ってくる
		 */
		LearningFileDAO fileDAO = new LearningFileDAO();
		ArrayList<LearningFile> fileList = new ArrayList<LearningFile>();
		fileList = fileDAO.searchFileForRubric(studentId, lessonId);
		request.setAttribute("fileList", fileList);

		getServletContext().getRequestDispatcher("/Public/student/rubric" + lessonId + ".jsp").forward(request,
				response);
	}
}