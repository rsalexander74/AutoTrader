package org.daggre.autotrader.reasoning;


public class TradingController {
	
    
	static int quesID=0;
	static double max_Points=0;
	static int max_Percentage=0;
	static int[] ques_History;
	static int[] questions_AT;
	static String[] history_dates;
	static int default_Outcome=0;
	static int noOfDays=0;
	static int initialPercentage=0;
	static int increment=0;
	static int previousPercentage=0;
	static String username="";
	static String fileName="";
	static String nodeName="";
	static String password="";
	static int policy=0;
	static int minNoOfDays=0;
	public TradingController(){}
	//all getter methods
	public static String get_NodeName(){return nodeName;}
	public static String get_fileName(){return fileName;}
	public static String get_Username(){return username;}
	public static String get_Password(){return password;}
	public static int get_prevPercentage(){return previousPercentage;}
	public static int get_policy(){return policy;}
	public static int get_increment(){
		return increment;
	}
	public static String[] get_histDates(){
		return history_dates;
	}
	public static int get_initialPercentage(){
		return initialPercentage;
	}
    public static int get_noOfDays(){return noOfDays;}
    public static int get_minNoOfDays(){return minNoOfDays;}
	public static int get_quesID(){
		return quesID;
	}

	public static double get_Max_Points(){
	return max_Points;	
	}

	public static int get_Max_Percentage(){
		return max_Percentage;
	}

	public static int[] get_ques_History(){
	return ques_History;	
	}

	public static int[] get_questions_AT(){
	return questions_AT;	
	}

	public static int get_default(){
		return default_Outcome;
	}
	
	
	//all the setters
	public void set_Username(String user){
		this.username=user;
	}
	public void set_Password(String pass){
		this.password=pass;
	}
	public void set_fileName(String file){
		this.fileName=file;
	}
	public void set_nodeName(String node){
		this.nodeName=node;
	}
	public void set_Policy(int poli){
		this.policy=poli;
	}
	public void set_prevPerce(int prev){
		this.previousPercentage=prev;
	}
	public void set_historyDates(String [] hist_dates){
		this.history_dates=hist_dates;
	}
	public void set_increment(int incre){
		this.increment=incre;
	}
	public void set_initialPercentage(int initial){
		this.initialPercentage=initial;
	}
	public void set_quesId(int quesID){
		this.quesID=quesID;
	}

	public void set_Max_Points(double max_Points){
	    this.max_Points=max_Points;	
	}

	public void set_Max_Percentage(int max_Percentage){
		this.max_Percentage=max_Percentage;
	}

	public void set_ques_History(int [] ques_History){
	   this.ques_History=ques_History;	
	}

	public void set_questions_AT(int [] questions_AT){
	this.questions_AT=questions_AT;	
	}
	public void set_noOfDays(int noDays){
		this.noOfDays=noDays;
		}
	public void set_minNoOfDays(int days){
		this.minNoOfDays=days;
		}
public void set_default(int defaultVal){
	this.default_Outcome=defaultVal;
}
	
}

























