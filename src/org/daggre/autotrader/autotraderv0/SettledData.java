package org.daggre.autotrader.autotraderv0;

import org.daggre.autotrader.communication.InformationCommunicator;
import org.daggre.autotrader.reasoning.Validator;

public class SettledData {
	static String username="autotraderK3";
	static String password="ralexan3";
	String start_date=null;
	String end_date=null;
	InformationCommunicator InfoObj=new InformationCommunicator();
	Validator validObj=new Validator();
	SettledData(String sdate,String edate){
		start_date=sdate;
		end_date=edate;
		
	}
	public void flow(){
		int startDays=validObj.noOfDays(start_date);
		int endDays=validObj.noOfDays(end_date);
	for(int i=1;i<202;i++){
		int quesId=i;
		try{
		String date=InfoObj.getSettlementDate(quesId, username, password);
		int days=validObj.noOfDays(date);
            		if(days>startDays && days<endDays){
			                double settledValue=InfoObj.getSettled_Value(quesId, username, password);
			                System.out.println(quesId+":     settled on:"+date+"           settled Value:"+settledValue);
		                                              }
		            else{
			             continue;
		                 }
		
		
	              }	

	catch(Exception e){
		continue;
		}
	}
		
		
	  
	
	}	
	
}
