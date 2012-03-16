package org.daggre.autotrader.reasoning;

public class TradingManager1 implements TradingManagerIntfc {

	TradingManager1(){}


	

@Override
public int reviseTrade(int estimatedPercentage){
		//System.out.println("revise trade");
	int initialPercentage=TradingController.get_initialPercentage();
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
	public int exploreTrade() {
		// TODO Auto-generated method stub
		return 0;
	}



	
	
	
}
