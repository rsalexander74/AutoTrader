package org.daggre.autotrader.reasoning;

public class Validator {
Validator(){}
// all validations required to proceed to trading
public boolean	withinTradeWindow(int noOfDays,int minNoDays){//checks whether its in the trading window
	
	    if(noOfDays<=minNoDays){
		System.out.println("within trade window");
		return true;
	    }
	    else 
	    	return false;
}
public boolean balanceCheck(int balance,int minBalance){// checks whether the points are sufficient to trade and trades only if more than 100

	if(balance > minBalance){
	System.out.println("sufficient points");
	return true;	
	}
	else 
	return false;
}
public boolean sufficientPoints(double maxPoints,double estimatedPoints){//checks whether the estimated points are less than the max points willing to be spent
       if(estimatedPoints>maxPoints){
          return false;
       }
       else
	      return true;
}

public boolean sufficientPercentage(int maxPercentage,int estimatedPercentage,int initialPercentage){
	int percentage;
	if(estimatedPercentage>initialPercentage){
		percentage=estimatedPercentage-initialPercentage;
		if(percentage>maxPercentage)
		return false;
		else
		return true;
	}
	else if(estimatedPercentage<initialPercentage) {
		percentage=initialPercentage-estimatedPercentage;
		if(percentage>maxPercentage)
			return false;
		else
			return true;
	}
	else
		return true;
}







}

