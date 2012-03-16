package org.daggre.autotrader.communication;
import org.daggre.autotrader.reasoning.*;

public class Test {
static int[] quesID={173,94,105,151,148,171,74,100};
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] quesid;
		//EstimateDate date1=new EstimateDate();
		InformationCommunicator his= new InformationCommunicator();
		// TODO Auto-generated method stub
		/*int [] history=null;
         history=his.quesHistory(173, "autotraderk1", "ralexan3");
         for(int i=0;i<history.length;i++)
	    //System.out.println(history[i]);
	
      //    int out=his.setTrade(10,173,"autotraderk1", "ralexan3");
	      //double out1=(Double.parseDouble(out))*100;
	      //int out2=(int)out1;
	     // System.out.println(out);
	   //   double [] points=null;
	      points=his.getPoints("autotraderk1", "ralexan3");
	      for(int i=0;i<3;i++)
	    	  System.out.println(points[i]);
	     String date1=his.getSettlementDate(153, "autotraderk1", "ralexan3");
	     //System.out.println(date1);
	      Validator valid=new Validator();
	    // System.out.println(valid.noOfDays(date1));
	*/
		Validator valid=new Validator();
		System.out.println(valid.noOfDays(his.getSettlementDate(173,"autotraderk1", "ralexan3")));
			//for(int i=0;i<quesid.length;i++)
			//System.out.println(quesid[i]);
			
		}
		
		
	}
	

