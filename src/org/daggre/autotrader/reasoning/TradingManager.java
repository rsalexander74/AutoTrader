package org.daggre.autotrader.reasoning;

public class TradingManager implements TradingManagerIntfc {
	TradingManager(){}
	int estimatedPoints=0;
	//trading operations
	//calculation according to the data available like question history
public int	exploreTrade(int [] quesHistory,int noOfDays,int defaultValue){
		//System.out.println("explore trade");
		int estimatedPercentage=0;
				int temp=0;
				int tempHistory=0;
		temp=quesHistory[0];
		//algorithm
		tempHistory=(100-temp)/(noOfDays);
		if(defaultValue==0){
		estimatedPercentage=temp-tempHistory;
		return estimatedPercentage;
		}
		else
		{
			estimatedPercentage=temp+tempHistory;
			return estimatedPercentage;
		
		}
}
	// calculation according points available and other criteria 
//yet to be added estimated points retrival from estimated percentage
public int reviseTrade(int estimatedPercentage,int initialPercentage){
		//System.out.println("revise trade");
		if(estimatedPercentage>initialPercentage)
			return estimatedPercentage-1;
		
		else if(estimatedPercentage<initialPercentage)
			return estimatedPercentage+1;
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
