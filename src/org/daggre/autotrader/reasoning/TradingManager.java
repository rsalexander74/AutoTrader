package org.daggre.autotrader.reasoning;

public class TradingManager implements TradingManagerIntfc {
	TradingManager(){}
	int estimatedPoints=0;
	//trading operations
	//calculation according to the data available like question history
	/*
public int	exploreTrade(int [] quesHistory,int noOfDays,int defaultValue){
		//System.out.println("explore trade");
        
		int estimatedPercentage=0;
				int initial=0;
				//int tempHistory=0;
		initial=quesHistory[0];
		//algorithm
		
		if(defaultValue==0){
		estimatedPercentage=initial/noOfDays;
		estimatedPercentage=initial-estimatedPercentage;
		return estimatedPercentage;
		}
		else
		{
			estimatedPercentage=(100-initial)/noOfDays;
			estimatedPercentage=initial+estimatedPercentage;
			return estimatedPercentage;
		
		}
}
*/
public int exploreTrade(){
	
	//System.out.println("explore trade");
    
	int estimatedPercentage=0;
			int initial=TradingController.get_initialPercentage();
			//int tempHistory=0;
	int defaultValue=TradingController.get_default();
	int days=TradingController.get_noOfDays();
	//algorithm
	
	if(defaultValue==0){
	estimatedPercentage=initial/days;
	estimatedPercentage=initial-estimatedPercentage;
	return estimatedPercentage;
	}
	else
	{
		estimatedPercentage=(100-initial)/days;
		estimatedPercentage=initial+estimatedPercentage;
		return estimatedPercentage;
	
	}
	
	
	
	
	
	
	
	
	
	
	
}
	// calculation according points available and other criteria 
//yet to be added estimated points retrival from estimated percentage
public int reviseTrade(int estimatedPercentage){
		//System.out.println("revise trade");
	int defaultVal=TradingController.get_default();
		if(defaultVal==0)
			return estimatedPercentage+1;
		
		else if(defaultVal==1)
			return estimatedPercentage-1;
		else
			return estimatedPercentage;
		
}	
	// committing the trade 
public int commitTrade(int revisedPercentage){
		//System.out.println("commit trade");
	int commitTrade=0;
	commitTrade=revisedPercentage;
	return commitTrade;
}




}
