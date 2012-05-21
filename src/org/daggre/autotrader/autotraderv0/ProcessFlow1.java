package org.daggre.autotrader.autotraderv0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.daggre.autotrader.communication.InformationCommunicator;

import unbbayes.io.NetIO;
import unbbayes.prs.INode;
//import unbbayes.prs.bn.AssetNetwork;
//import unbbayes.prs.bn.Clique;
import unbbayes.prs.bn.JeffreyRuleLikelihoodExtractor;
import unbbayes.prs.bn.JunctionTreeAlgorithm;
//import unbbayes.prs.bn.PotentialTable;
import unbbayes.prs.bn.ProbabilisticNetwork;
import unbbayes.prs.bn.TreeVariable;

//import unbbayes.prs.bn.cpt.IArbitraryConditionalProbabilityExtractor;
//import unbbayes.prs.bn.cpt.impl.InCliqueConditionalProbabilityExtractor;

public class ProcessFlow1 {
	
	static String username="autotraderK3";
	static String password="ralexan3";
	static String[] nodes={"Germany","Withraw","Hypothesis"};
	static int[] quesId={195,196,109};
	InformationCommunicator InfoObj=new InformationCommunicator();
	ProcessFlow1(){}
	public void flow(){
		
		File file = null;
		try {
			
			file = new File("GreekExitv2.2.net");
		
		} 
		catch (Exception e) {
		
			System.out.println(e);
		}
			
		NetIO netio = new NetIO();
		ProbabilisticNetwork network = null;
		try {
			
			network = (ProbabilisticNetwork)netio.load(file);
			
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
		
		
		
		for(int i=0;i<quesId.length-1;i++)
		{
			
			float current=((float)InfoObj.quesHistory(quesId[i],username,password)[0])/100;
			TreeVariable supportingNode = (TreeVariable) network.getNode(nodes[i]);
			
			System.out.println(supportingNode+"           ques:"+quesId[i]+"          Percentage:"+(current*100));
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
		TreeVariable nodeToTest = (TreeVariable) network.getNode(nodes[nodes.length-1]);
		double est = nodeToTest.getMarginalAt(0);
		System.out.println("The output of the market for question:"+quesId[quesId.length-1]+"   is:" +InfoObj.quesHistory(quesId[quesId.length-1], username, password)[0]);
		System.out.println("UnBayyes output:"+((1-est)*100));
		
	}

}
