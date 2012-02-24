package org.daggre.autotrader.translation;

public class Controller {
	static ActionType nextCommunicatorAction;
	static ActionType nextReasonerAction;
	static double questionEstimate;
	static int questionID;
	static double ifTrue;
	static double ifFalse;
	
	//Reasoner calls this method when it has an estimate to send
	public void setEstimate (double estimate, int questionIDNum) {
		questionEstimate = estimate;
		questionID = questionIDNum;
		readyForCommunicator(ActionType.ESTIMATE);
                System.out.println("Controller.setEstimate: "
                        + "questionEstimate == " + questionEstimate
                        + ", questionID == " + questionID);
	} 
	
	//Reasoner setters call this method when it has posted data for 
	//communicator to act on. Communicator reads this inside communicator package
	public void readyForCommunicator (ActionType type) {
		nextCommunicatorAction = type;
	}
	
	public void setIfTrueIfFalse (double ifTrueVal, double ifFalseVal) {
		ifTrue = ifTrueVal;
		ifFalse = ifFalseVal;
		readyForReasoner(ActionType.IFTRUEIFFALSE);
	}
	
	//Communicator setters call this method when it has posted data for 
	//reasoner to act on.  Reasoner reads this inside reasoning package
	public void readyForReasoner (ActionType type) {
		nextReasonerAction = type;
	}

}
