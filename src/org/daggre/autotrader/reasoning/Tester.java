package org.daggre.autotrader.reasoning;

public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] history={54,55};
		int days=14;
		int defaultVal=0;
		TradingController tm=new TradingController();
		Validator valid=new Validator();
		tm.set_ques_History(history);
		tm.set_default(defaultVal);
		tm.set_initialPercentage(history[0]);
		tm.set_noOfDays(days);
		tm.set_Max_Percentage(1);
		System.out.println(TradingController.get_default()+"    "+TradingController.get_initialPercentage());
	TradingManager tmObj=new TradingManager();
	//System.out.println(tmObj.exploreTrade(history, days, defaultVal));
	/*
	int per=tmObj.exploreTrade();
	boolean check=valid.sufficientPercentage(per);
	while(check==false){
		per=tmObj.reviseTrade(per);
        check=valid.sufficientPercentage(per)	;
	}
	System.out.println(per);
	TradingManagerFactory FacObj=new TradingManagerFactory();
	per=FacObj.policySelect(0).exploreTrade();
	System.out.println(per);*/
	boolean check;
	int percentage,per1;
	TradingManagerFactory FacObj=new TradingManagerFactory();
	 percentage=FacObj.policySelect(0).exploreTrade();
	
	 //Validator valid=new Validator();
	check=valid.sufficientPercentage(percentage);
	while(check==false){
		per1=FacObj.policySelect(0).reviseTrade(percentage);
		percentage=per1;
		check=valid.sufficientPercentage(percentage);	
	}
	System.out.println(percentage+"     "+check);
			
	
	}

}
