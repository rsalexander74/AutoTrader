package org.daggre.autotrader.reasoning;

public class TradingController {

	int quesID=0;
	double max_Points=0;
	double max_Percentage=0;
	int[] ques_History;
	int[] questions_AT;
	boolean default_Outcome=false;

	TradingController(){}
	//all getter methods

	public int get_quesID(){
		return quesID;
	}

	public double get_Max_Points(){
	return max_Points;	
	}

	public double get_Max_Percentage(){
		return max_Percentage;
	}

	public int[] get_ques_History(){
	return ques_History;	
	}

	public int[] get_questions_AT(){
	return questions_AT;	
	}

	
	
	
	//all the setters
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
     

	
}

























