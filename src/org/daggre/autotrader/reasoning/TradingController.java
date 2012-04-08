package org.daggre.autotrader.reasoning;

public class TradingController {

	static int quesID=0;
	static double max_Points=0;
	static int max_Percentage=0;
	static int[] ques_History;
	static int[] questions_AT;
	static int default_Outcome=0;
	static int noOfDays=0;
	static int initialPercentage=0;
	static int increment=0;

	public TradingController(){}
	//all getter methods
	public static int get_increment(){
		return increment;
	}
	public static int get_initialPercentage(){
		return initialPercentage;
	}
    public static int get_noOfDays(){return noOfDays;}
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
public void set_default(int defaultVal){
	this.default_Outcome=defaultVal;
}
	
}

























