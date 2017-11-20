package beans;

public class ResponseData{

	private int id = 0; //通し番号
	private int lesson_id = 0; //授業id
	private String student_id = null; //学習者id
	private double indegree = 0;//入次数
	private double indegree_mean = 0;//入次数平均
	private double outdegree =0;//出次数
	private double outdegree_mean=0;//出次数平均
	private double betweenness=0;//媒介中心性
	private double betweenness_mean=0;//媒介中心性平均
	private int membership =0;//コミュニティ番号


	public ResponseData(int id,int lesson_id,String student_id,double indegree,double indegree_mean,
			double outdegree,double outdegree_mean,double betweenness,double betweenness_mean,int membership){

		this.id = id;
		this.lesson_id = lesson_id;
		this.student_id = student_id;
		this.indegree = indegree;
		this.indegree_mean = indegree_mean;
		this.outdegree = outdegree;
		this.outdegree_mean = outdegree_mean;
		this.betweenness = betweenness;
		this.betweenness_mean = betweenness_mean;
		this.membership = membership;
	}


	public ResponseData() {
		// TODO 自動生成されたコンストラクター・スタブ
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getLesson_id() {
		return lesson_id;
	}


	public void setLesson_id(int lesson_id) {
		this.lesson_id = lesson_id;
	}


	public String getStudent_id() {
		return student_id;
	}


	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}


	public double getIndegree() {
		return indegree;
	}


	public void setIndegree(double indegree) {
		this.indegree = indegree;
	}


	public double getIndegree_mean() {
		return indegree_mean;
	}


	public void setIndegree_mean(double indegree_mean) {
		this.indegree_mean = indegree_mean;
	}


	public double getOutdegree() {
		return outdegree;
	}


	public void setOutdegree(double outdegree) {
		this.outdegree = outdegree;
	}


	public double getOutdegree_mean() {
		return outdegree_mean;
	}


	public void setOutdegree_mean(double outdegree_mean) {
		this.outdegree_mean = outdegree_mean;
	}


	public double getBetweenness() {
		return betweenness;
	}


	public void setBetweenness(double betweenness) {
		this.betweenness = betweenness;
	}


	public double getBetweenness_mean() {
		return betweenness_mean;
	}


	public void setBetweenness_mean(double betweenness_mean) {
		this.betweenness_mean = betweenness_mean;
	}


	public int getMembership() {
		return membership;
	}


	public void setMembership(int membership) {
		this.membership = membership;
	}


}