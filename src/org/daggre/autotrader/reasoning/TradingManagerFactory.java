package org.daggre.autotrader.reasoning;

public class TradingManagerFactory {
TradingManagerFactory(){}
	//policy selection of trading factory
	public Object policySelect(int policy_Default)	
	{
		if(policy_Default==0){
			System.out.println("TradingManager object");
			TradingManager tmObj=new TradingManager();	
		    return tmObj;
		}
		else {
			System.out.println("TradingManager1 object");
			TradingManager1 tmObj=new TradingManager1();
			return tmObj;
		}
		
		
	}	

	
}
