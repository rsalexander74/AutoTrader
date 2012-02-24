package org.daggre.autotrader.Communication;

import org.daggre.autotrader.Translation;

public class Communicator {

	double questionEstimate;
	int questionID;
	double ifTrue;
	double ifFalse;
	Controller ready;
	
	public Communicator(){
	ready= new Controller();
	}
	//Communicator get the data from the reasoner upon the call from translator
	public void getData(double estimate, int questionIDNum) {
	questionEstimate = estimate;
	questionID = questionIDNum;
	readyforServer();
	}
	//Communicator check for the server to send data
	public void readyforServer() {
	}
	//takes data from the server and is ready for sending it to the reasoner
	public void sendData(double estimate, int questionIDNum) {
	questionEstimate = estimate;
	questionID = questionIDNum;
	Controller.readyforReasoner();//call translator to inform the reasoner to fetch data
	}
}