package org.calibration;

public class Output extends Thread{
	public void run() {
	      while( true) {
	     
	      try {
	       
	        Thread.sleep(20);
	      }
	      catch (InterruptedException ex) {}
	    }
	  }
}
