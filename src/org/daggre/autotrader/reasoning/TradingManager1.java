package org.daggre.autotrader.reasoning;

public class TradingManager1 implements TradingManagerIntfc {

	TradingManager1(){}


	

@Override
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
@Override
public int commitTrade(int revisedPercentage){
		//System.out.println("commit trade");
	int commitTrade=0;
	commitTrade=revisedPercentage;
	return commitTrade;
}






	@Override
	public int exploreTrade(int[] quesHistory,int noOfDays,int defaultValue) {
		// TODO Auto-generated method stub
		return 0;
	}



	
	
	
}
