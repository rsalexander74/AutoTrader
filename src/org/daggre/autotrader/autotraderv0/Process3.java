package org.daggre.autotrader.autotraderv0;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.daggre.autotrader.communication.InformationCommunicator;
import org.daggre.autotrader.reasoning.JdbcImpl;
import org.daggre.autotrader.reasoning.TradingController;
import org.daggre.autotrader.reasoning.TradingManagerFactory;
import org.daggre.autotrader.reasoning.Validator;

import unbbayes.io.NetIO;
import unbbayes.prs.INode;
import unbbayes.prs.bn.JeffreyRuleLikelihoodExtractor;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.TreeVariable;

public class Process3 {

	InformationCommunicator InfoObj=new InformationCommunicator();
	TradingController TradContObj=new TradingController();
	JdbcImpl jdbcObj=new JdbcImpl();
	Process3(){}
	public void flow3(){
		int k=jdbcObj.getQuesId().length;
		int[] quesId=null;
		quesId=new int[k];
		quesId=jdbcObj.getQuesId();
		
		for(int i=0;i<quesId.length;i++){
			jdbcObj.getQuesInfo(quesId[i]);
			jdbcObj.getPassword(TradingController.get_Username());
			if(TradingController.get_policy()==0){
				ProcessFlow(quesId[i]);	
			}
			
			else if(TradingController.get_policy()==1){
				int[] suppQues=jdbcObj.support_info(quesId[i]);
				jdbcObj.getFileName(quesId[i]);
				String[] nodes=null;
				nodes=new String[suppQues.length];
				for(int j=0;j<suppQues.length;j++){
					nodes[j]=jdbcObj.getNodeName(suppQues[j]);
					}	
			      flow(suppQues,nodes);
			
			
			}
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	public void ProcessFlow(int quesId){
		String username=TradingController.get_Username();
		
		String password=TradingController.get_Password();
	
		       // TradContObj.set_default(defaultValue[i]);
			    Validator valid=new Validator();
		        //TradContObj.set_quesId(quesId[i]);
		        //TradContObj.set_Max_Percentage(max_Percentage);
		        String date=InfoObj.getSettlementDate(quesId,username, password);
		        TradContObj.set_noOfDays(valid.noOfDays(date));
		        TradContObj.set_ques_History(InfoObj.quesHistory(quesId,username,password));
		        TradContObj.set_initialPercentage(InfoObj.quesHistory(quesId,username,password)[0]);
		   System.out.println("QuestionID="+TradingController.get_quesID());
		   System.out.println("default="+TradingController.get_default());
		   System.out.println("initial percentage="+TradingController.get_initialPercentage());
		   System.out.println("no of days left="+TradingController.get_noOfDays());
		    //System.out.println("default="+TradingController.get_ques_History()[0]);
		    System.out.println("valid="+validityCheck(quesId, username, password));  
		boolean check;
		       int finalCommit;
		     //  TradContObj.set_default(defaultValue[i]);
		try{
		check=validityCheck(quesId, username, password);
			if(check==true){
				finalCommit=algorithm();
			if(finalCommit>0 && finalCommit<100 && finalCommit!=TradingController.get_initialPercentage()){
			InfoObj.setTrade(finalCommit, quesId, username, password);		
			System.out.println("Username="+username+"  quesNo="+quesId+"       initial percentage"+TradingController.get_initialPercentage()+"     percentage commited="+finalCommit+"   No of days"+TradingController.get_noOfDays());
			System.out.println("      ");
			}
			else{
				System.out.println("low commit or percentae change remained same");
			    System.out.println("");
			}
			}
			else{
				System.out.println("criteria not met");
				System.out.println("");
				
				
			}
			}
		catch(Exception e){
			System.out.println(e);
		}
		
		}

			

		public boolean validityCheck(int quesId,String username,String password){
			int days;
			double[] points;
			boolean tradeWindow,quesValid;//balanceCheck;
			
			Validator valid=new Validator();
			days=TradingController.get_noOfDays();
			points=InfoObj.getPoints(username, password);
			tradeWindow=valid.withinTradeWindow(days, TradingController.get_minNoOfDays());
			//balanceCheck=valid.balanceCheck(points[1], minBalance);
			quesValid=InfoObj.quesCheck1(quesId, username, password);
			if(tradeWindow==true&&quesValid==true)
				return true;
			else	
				return false;
		}
			
			
			public int algorithm(){
				boolean check1;
				int percentage;
				int policy=TradingController.get_policy();
				TradingManagerFactory FacObj=new TradingManagerFactory();
				percentage=FacObj.policySelect(policy).exploreTrade();
				Validator valid=new Validator();
				check1=valid.sufficientPercentage(percentage);
				while(check1==false){
					percentage=FacObj.policySelect(policy).reviseTrade(percentage);
					check1=valid.sufficientPercentage(percentage);	
				}
				return percentage;
						
			}
	
			public void flow(int[] suppQues,String[] nodes){
				
				File file = null;
				try {
					
					file = new File("input/"+TradingController.get_fileName());
				
				} 
				catch (Exception e) {
					System.out.println(e);
				}
					
				NetIO netio = new NetIO();
				ProbabilisticNetwork network = null;
				try {
					network = (ProbabilisticNetwork) netio.load(file);
				} 
				catch (Exception e) {
					e.printStackTrace();
			
				}
						

				JunctionTreeAlgorithm junctionTreeAlgorithm = new JunctionTreeAlgorithm(network);
				junctionTreeAlgorithm.setLikelihoodExtractor(JeffreyRuleLikelihoodExtractor.newInstance() );
			
				try {
					junctionTreeAlgorithm.run();
							
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
				for(int i=0;i<suppQues.length;i++)
				{
					
					float current=((float)InfoObj.quesHistory(suppQues[i],TradingController.get_Username(), TradingController.get_Password())[0])/100;
					TreeVariable supportingNode = (TreeVariable) network.getNode(nodes[i]);
					
					System.out.println(supportingNode+"           ques:"+suppQues[i]+"          Percentage:"+(current*100));
					List<INode> secondaryConditions =  new ArrayList<INode>();
					float likelihood[] = new float[2]; 				
					likelihood[0] =  current;
					likelihood[1] = 1-current;
					supportingNode.addLikeliHood(likelihood, secondaryConditions);
					try {
						junctionTreeAlgorithm.propagate();
					
					} 
					catch (Exception e) {
						System.out.println(e);			
						}	
					
				}
				TreeVariable nodeToTest = (TreeVariable) network.getNode(TradingController.get_NodeName());
				double est = nodeToTest.getMarginalAt(0);
				System.out.println("The output of the market for question:"+TradingController.get_quesID()+"   is:" +InfoObj.quesHistory(TradingController.get_quesID(),TradingController.get_Username(), TradingController.get_Password())[0]);
				if(TradingController.get_default()==1)
				System.out.println("UnBayyes output:"+((1-est)*100));
				else
					System.out.println("UnBayyes output:"+(est*100));
			}
	
	
	
	
	
}
