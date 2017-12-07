package beans;

public class AnalysisData {

	private int id = 0; // 通し番号
	private int lessonId = 0; // 授業id
	private int studentId = 0; // 学習者id
	private double indegree = 0;// 入次数
	private double indegreeMean = 0;// 入次数平均
	private double outdegree = 0;// 出次数
	private double outdegreeMean = 0;// 出次数平均
	private double betweenness = 0;// 媒介中心性
	private double betweennessMean = 0;// 媒介中心性平均
	private int membership = 0;// コミュニティ番号

	public AnalysisData(int id, int lessonId, int studentId, double indegree, double indegreeMean, double outdegree,
			double outdegreeMean, double betweenness, double betweennessMean, int membership) {

		this.id = id;
		this.lessonId = lessonId;
		this.studentId = studentId;
		this.indegree = indegree;
		this.indegreeMean = indegreeMean;
		this.outdegree = outdegree;
		this.outdegreeMean = outdegreeMean;
		this.betweenness = betweenness;
		this.betweennessMean = betweennessMean;
		this.membership = membership;
	}

	public AnalysisData() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public double getIndegree() {
		return indegree;
	}

	public void setIndegree(double indegree) {
		this.indegree = indegree;
	}

	public double getIndegreeMean() {
		return indegreeMean;
	}

	public void setIndegreeMean(double indegreeMean) {
		this.indegreeMean = indegreeMean;
	}

	public double getOutdegree() {
		return outdegree;
	}

	public void setOutdegree(double outdegree) {
		this.outdegree = outdegree;
	}

	public double getOutdegreeMean() {
		return outdegreeMean;
	}

	public void setOutdegreeMean(double outdegreeMean) {
		this.outdegreeMean = outdegreeMean;
	}

	public double getBetweenness() {
		return betweenness;
	}

	public void setBetweenness(double betweenness) {
		this.betweenness = betweenness;
	}

	public double getBetweennessMean() {
		return betweennessMean;
	}

	public void setBetweennessMean(double betweennessMean) {
		this.betweennessMean = betweennessMean;
	}

	public int getMembership() {
		return membership;
	}

	public void setMembership(int membership) {
		this.membership = membership;
	}

}