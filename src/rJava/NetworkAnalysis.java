package rJava;

import java.util.ArrayList;
import java.util.List;

import org.rosuda.JRI.REXP;
import org.rosuda.JRI.Rengine;

public class NetworkAnalysis {

	public NetworkAnalysis() {
	}

	// 入次数の算出
	public ArrayList<Double> indegree(List<ArrayList<String>> peerAssessmentList) {
		// System.out.println(peerAssessmentList);
		Rengine re = Rengine.getMainEngine();
		if (re == null)
			re = new Rengine(new String[] { "--vanilla" }, false, null);

		StringBuffer buf = new StringBuffer();
		buf.append("e.list<-c(");
		for (int i = 0; i < peerAssessmentList.size(); i++) {
			for (int j = 0; j < peerAssessmentList.get(i).size(); j++) {
				if (i == peerAssessmentList.size() - 1 && j == peerAssessmentList.get(i).size() - 1) {
					buf.append(peerAssessmentList.get(i).get(j) + ")");
				} else {
					buf.append(peerAssessmentList.get(i).get(j) + ",");
				}
			}
		}
		String c_value = buf.toString();
		re.eval("e.list <-" + c_value);
		re.eval("library(igraph)");
		re.eval("e.matrix <- matrix(e.list,ncol=2,byrow=TRUE)");
		re.eval("g<- graph.edgelist(e.matrix)");
		REXP n = re.eval("degree(g,mode='in')");
		double[] array = n.asDoubleArray();
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		// System.out.println(list);
		return list;
	}

	// 入次数平均
	public Double indegreeMean(List<ArrayList<String>> peerAssessmentList) {
		Rengine re = Rengine.getMainEngine();
		if (re == null)
			re = new Rengine(new String[] { "--vanilla" }, false, null);
		StringBuffer buf = new StringBuffer();
		buf.append("e.list<-c(");
		for (int i = 0; i < peerAssessmentList.size(); i++) {
			for (int j = 0; j < peerAssessmentList.get(i).size(); j++) {
				if (i == peerAssessmentList.size() - 1 && j == peerAssessmentList.get(i).size() - 1) {
					buf.append(peerAssessmentList.get(i).get(j) + ")");
				} else {
					buf.append(peerAssessmentList.get(i).get(j) + ",");
				}
			}
		}
		String c_value = buf.toString();
		re.eval("e.list <-" + c_value);
		re.eval("library(igraph)");
		re.eval("e.matrix <- matrix(e.list,ncol=2,byrow=TRUE)");
		re.eval("g<- graph.edgelist(e.matrix)");
		re.eval("x<-degree(g,mode='in')");
		REXP mean = re.eval("mean(x)");
		double x = mean.asDouble();
		return x;
	}

	// 出次数の算出
	public ArrayList<Double> outdegree(List<ArrayList<String>> peerAssessmentList) {
		Rengine re = Rengine.getMainEngine();
		if (re == null)
			re = new Rengine(new String[] { "--vanilla" }, false, null);
		StringBuffer buf = new StringBuffer();
		buf.append("e.list<-c(");
		for (int i = 0; i < peerAssessmentList.size(); i++) {
			for (int j = 0; j < peerAssessmentList.get(i).size(); j++) {
				if (i == peerAssessmentList.size() - 1 && j == peerAssessmentList.get(i).size() - 1) {
					buf.append(peerAssessmentList.get(i).get(j) + ")");
				} else {
					buf.append(peerAssessmentList.get(i).get(j) + ",");
				}
			}
		}
		String c_value = buf.toString();
		re.eval("e.list <-" + c_value);
		re.eval("library(igraph)");
		re.eval("e.matrix <- matrix(e.list,ncol=2,byrow=TRUE)");
		re.eval("g<- graph.edgelist(e.matrix)");
		REXP n = re.eval("degree(g,mode='out')");
		double[] array = n.asDoubleArray();
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}

	// 出次数平均
	public Double outdegreeMean(List<ArrayList<String>> peerAssessmentList) {
		Rengine re = Rengine.getMainEngine();
		if (re == null)
			re = new Rengine(new String[] { "--vanilla" }, false, null);
		StringBuffer buf = new StringBuffer();
		buf.append("e.list<-c(");
		for (int i = 0; i < peerAssessmentList.size(); i++) {
			for (int j = 0; j < peerAssessmentList.get(i).size(); j++) {
				if (i == peerAssessmentList.size() - 1 && j == peerAssessmentList.get(i).size() - 1) {
					buf.append(peerAssessmentList.get(i).get(j) + ")");
				} else {
					buf.append(peerAssessmentList.get(i).get(j) + ",");
				}
			}
		}
		String c_value = buf.toString();
		re.eval("e.list <-" + c_value);
		re.eval("library(igraph)");
		re.eval("e.matrix <- matrix(e.list,ncol=2,byrow=TRUE)");
		re.eval("g<- graph.edgelist(e.matrix)");
		re.eval("x<-degree(g,mode='out')");
		REXP mean = re.eval("mean(x)");
		double x = mean.asDouble();
		return x;
	}

	// 媒介中心性の算出(今は有向グラフ）
	public ArrayList<Double> betweenness(List<ArrayList<String>> peerAssessmentList) {
		Rengine re = Rengine.getMainEngine();
		if (re == null)
			re = new Rengine(new String[] { "--vanilla" }, false, null);
		StringBuffer buf = new StringBuffer();
		buf.append("e.list<-c(");
		for (int i = 0; i < peerAssessmentList.size(); i++) {
			for (int j = 0; j < peerAssessmentList.get(i).size(); j++) {
				if (i == peerAssessmentList.size() - 1 && j == peerAssessmentList.get(i).size() - 1) {
					buf.append(peerAssessmentList.get(i).get(j) + ")");
				} else {
					buf.append(peerAssessmentList.get(i).get(j) + ",");
				}
			}
		}
		String c_value = buf.toString();
		re.eval("e.list <-" + c_value);
		re.eval("library(igraph)");
		re.eval("e.matrix <- matrix(e.list,ncol=2,byrow=TRUE)");
		re.eval("g<- graph.edgelist(e.matrix)");
		REXP n = re.eval("betweenness(g)");
		// System.out.println(String.valueOf(n));
		double[] array = n.asDoubleArray();
		ArrayList<Double> list = new ArrayList<Double>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		return list;
	}

	// 媒介中心性平均
	public Double betweennessMean(List<ArrayList<String>> peerAssessmentList) {
		Rengine re = Rengine.getMainEngine();
		if (re == null)
			re = new Rengine(new String[] { "--vanilla" }, false, null);
		StringBuffer buf = new StringBuffer();
		buf.append("e.list<-c(");
		for (int i = 0; i < peerAssessmentList.size(); i++) {
			for (int j = 0; j < peerAssessmentList.get(i).size(); j++) {
				if (i == peerAssessmentList.size() - 1 && j == peerAssessmentList.get(i).size() - 1) {
					buf.append(peerAssessmentList.get(i).get(j) + ")");
				} else {
					buf.append(peerAssessmentList.get(i).get(j) + ",");
				}
			}
		}
		String c_value = buf.toString();
		re.eval("e.list <-" + c_value);
		re.eval("library(igraph)");
		re.eval("e.matrix <- matrix(e.list,ncol=2,byrow=TRUE)");
		re.eval("g<- graph.edgelist(e.matrix)");
		re.eval("x<-betweenness(g)");
		REXP mean = re.eval("mean(x)");
		double x = mean.asDouble();
		return x;
	}

	// 凝集性
	public ArrayList<ArrayList<Integer>> community(List<ArrayList<String>> peerAssessmentList) {
		Rengine re = Rengine.getMainEngine();
		if (re == null)
			re = new Rengine(new String[] { "--vanilla" }, false, null);
		StringBuffer buf = new StringBuffer();
		buf.append("e.list<-c(");
		for (int i = 0; i < peerAssessmentList.size(); i++) {
			for (int j = 0; j < peerAssessmentList.get(i).size(); j++) {
				if (i == peerAssessmentList.size() - 1 && j == peerAssessmentList.get(i).size() - 1) {
					buf.append(peerAssessmentList.get(i).get(j) + ")");
				} else {
					buf.append(peerAssessmentList.get(i).get(j) + ",");
				}
			}
		}
		String c_value = buf.toString();
		re.eval("e.list <-" + c_value);
		REXP e = re.eval("e.list");
		// System.out.println(String.valueOf(e));
		re.eval("library(igraph)");
		re.eval("e.matrix <- matrix(e.list,ncol=2,byrow=TRUE)");

		re.eval("g<- graph.edgelist(e.matrix)");
		// re.eval("V(g)$name<-1:ncol(a)");
		re.eval("eb <- edge.betweenness.community(g)");
		// REXP eb = re.eval("eb");
		// System.out.println(String.valueOf(eb));
		/*
		 * REXP eb = re.eval("eb$menbership"); REXP ebLength =
		 * re.eval("length(eb$menbership)"); int length = ebLength.asInt();
		 * double[] ebList = eb.asDoubleArray(); ArrayList<Double> list = new
		 * ArrayList<Double>(); for(int i=1; i<=length;i++){
		 * list.add(ebList[i]); }
		 */
		REXP size = re.eval("length(eb)");
		int length = size.asInt();
		// System.out.println(String.valueOf(length));
		ArrayList<ArrayList<Integer>> bigList = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= length; i++) {
			REXP x = re.eval("eb[" + i + "]$'" + i + "'");
			// System.out.println(x);

			double[] menbershipList = x.asDoubleArray();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < menbershipList.length; j++) {
				int y = (int) menbershipList[j];
				list.add(y);
			}
			bigList.add(list);
		}
		// System.out.println(bigList);
		return bigList;
	}

	public ArrayList<Integer> menbership(List<ArrayList<String>> peerAssessmentList) {
		Rengine re = Rengine.getMainEngine();
		if (re == null)
			re = new Rengine(new String[] { "--vanilla" }, false, null);
		StringBuffer buf = new StringBuffer();
		buf.append("e.list<-c(");
		for (int i = 0; i < peerAssessmentList.size(); i++) {
			for (int j = 0; j < peerAssessmentList.get(i).size(); j++) {
				if (i == peerAssessmentList.size() - 1 && j == peerAssessmentList.get(i).size() - 1) {
					buf.append(peerAssessmentList.get(i).get(j) + ")");
				} else {
					buf.append(peerAssessmentList.get(i).get(j) + ",");
				}
			}
		}
		String c_value = buf.toString();
		re.eval("e.list <-" + c_value);
		// REXP e = re.eval("e.list");
		// System.out.println(String.valueOf(e));
		re.eval("library(igraph)");
		re.eval("e.matrix <- matrix(e.list,ncol=2,byrow=TRUE)");
		re.eval("g<- graph.edgelist(e.matrix)");
		re.eval("eb <- edge.betweenness.community(g)");
		REXP size = re.eval("length(eb$membership)");
		int length = size.asInt();
		// System.out.println(length);
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= length; i++) {
			REXP n = re.eval("eb$membership[" + i + "]");
			// System.out.println(String.valueOf(n));
			double menbership = n.asDouble();
			int x = (int) menbership;
			list.add(x);
		}
		return list;
	}

}
