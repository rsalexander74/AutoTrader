package org.daggre.autotrader.autotraderv0;
import org.daggre.autotrader.communication.*;
import org.daggre.autotrader.reasoning.*;
public class ProcessFlow {
static int[] quesId={157,155,6,32};
static int[] defaultValue={0,0,0,1};
static String username="autotraderk1";
static String password="ralexan3";
static int policy=0;
static int max_Percentage=3;
static double max_points=10.0;
static double minBalance=100;
static int minNoDays=60;
TradingController TradContObj=new TradingController();
InformationCommunicator InfoObj=new InformationCommunicator();
ProcessFlow(){
for(int i=0;i<quesId.length;i++){
        TradContObj.set_default(defaultValue[i]);
	    Validator valid=new Validator();
        TradContObj.set_quesId(quesId[i]);
        TradContObj.set_Max_Percentage(max_Percentage);
        String date=InfoObj.getSettlementDate(quesId[i],username, password);
        TradContObj.set_noOfDays(valid.noOfDays(date));
        TradContObj.set_ques_History(InfoObj.quesHistory(quesId[i],username,password));
        TradContObj.set_initialPercentage(InfoObj.quesHistory(quesId[i],username,password)[0]);
    System.out.println(TradingController.get_default());
    System.out.println(TradingController.get_initialPercentage());
    System.out.println(TradingController.get_noOfDays());
    System.out.println(TradingController.get_ques_History()[0]);
    System.out.println(validityCheck(quesId[i], username, password));  
boolean check;
       int finalCommit;
       TradContObj.set_default(defaultValue[i]);
try{
check=validityCheck(quesId[i], username, password);
	if(check==true){
		finalCommit=algorithm();
	if(finalCommit>0 && finalCommit<100){
	finalCommit=InfoObj.setTrade(finalCommit, quesId[i], username, password);		
	System.out.println(username+"   "+quesId[i]+"       initial percentage"+TradingController.get_initialPercentage()+"     percentage commited="+finalCommit+"   "+TradingController.get_noOfDays());
	}
	else
		System.out.println("low commit");
	}
	else{
		System.out.println("criteria not met");
		continue;
		
	}
	}
catch(Exception e){
	continue;
}
}
}

	

public boolean validityCheck(int quesId,String username,String password){
	int days;
	double[] points;
	boolean tradeWindow,quesValid,balanceCheck;
	
	Validator valid=new Validator();
	days=TradingController.get_noOfDays();
	points=InfoObj.getPoints(username, password);
	tradeWindow=valid.withinTradeWindow(days, minNoDays);
	balanceCheck=valid.balanceCheck(points[1], minBalance);
	quesValid=InfoObj.quesCheck1(quesId, username, password);
	if(tradeWindow==true && balanceCheck==true && quesValid==true)
		return true;
	else	
		return false;
}
	
	
	public int algorithm(){
		boolean check1;
		int percentage;
		TradingManagerFactory FacObj=new TradingManagerFactory();
		percentage=FacObj.policySelect(policy).exploreTrade();
		Validator valid=new Validator();
		check1=valid.sufficientPercentage(percentage);
		while(check1==false){
			percentage=FacObj.policySelect(policy).reviseTrade(percentage);
			check1=valid.sufficientPercentage(percentage);	
		}
		return percentage;
				
	}
	}
	
	
	
	

	
	

