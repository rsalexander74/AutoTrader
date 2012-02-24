/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.daggre.autotrader.autotraderv0;

import org.daggre.autotrader.communication.Broker;
import org.daggre.autotrader.reasoning.Reasoner;

/**
 *
 * @author ralexander
 */
public class TestHarness {
    
    public static void test() {
        Reasoner reasoner = new Reasoner();
        reasoner.test();
        Broker broker = new Broker();
        broker.test();
    }
    
    
}
