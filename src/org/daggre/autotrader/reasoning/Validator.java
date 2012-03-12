package org.daggre.autotrader.reasoning;
import java.util.*;
import java.text.*;
public class Validator {
public Validator(){}
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
public int noOfDays(String input){
	long time1=0;
    long time2=0;
    long temp=0;
    int noOfDays=0;
   SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd"); 
   Date t1=new Date();
   time2=t1.getTime();
   Date t = null; 

   try { 
       t = ft.parse(input);  
   } catch (ParseException e) { 
       System.out.println("Unparseable using "); 
   }
   time1=t.getTime();
   temp=time1-time2;
   temp=temp/86400000;
   noOfDays=(int)temp;
   return noOfDays;
		
}






}

