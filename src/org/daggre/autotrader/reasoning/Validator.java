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
public boolean balanceCheck(double balance,double minBalance){// checks whether the points are sufficient to trade and trades only if more than 100

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
	System.out.println("sufficientPercentage logic");
	int defaultVal=TradingController.get_default();
	if(defaultVal==0){
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
		return false;
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

public double[] estimatePoints(int initial_percnt,int estimated_percnt){//initial percentage is the present percentage and estimated percentage is the percentage will to be set
	double[] points=null;                 //points[0]=if_true,points[1]=if_false
	double temp=0,mm_scale;
	mm_scale=Math.log(2)/100;
	temp=(Math.log(estimated_percnt/initial_percnt)*100)*mm_scale;
	points=new double[2];
	points[0]=Math.round(temp)/100;//if_true
	temp=Math.log(((100-estimated_percnt)/(100-initial_percnt))/mm_scale )*100;
	points[1]=Math.round(temp)/100;//if_false
	return points;
	
}

public boolean sufficientPercentage(int estimatedPercentage){
	int percentage;
	int maxPercentage=TradingController.get_Max_Percentage();
	int initialPercentage=TradingController.get_initialPercentage();
	int defaultVal=TradingController.get_default();
	
	System.out.println("sufficientPercentage logic");
	if(defaultVal==1){
		percentage=estimatedPercentage-initialPercentage;
		if(percentage>maxPercentage)
		return false;
		else
		return true;
	}
	else if(defaultVal==0) {
		percentage=initialPercentage-estimatedPercentage;
		if(percentage>maxPercentage)
			return false;
		else
			return true;
	}
	else
		return false;
	
	
	
	
	
	
}


}

