package com.retroduction.carma.core.runner.utililties;

public class StopWatch {
	private long startTime;
	public void start(){
		startTime = System.currentTimeMillis();
	}
	
	public long stop(){
		return System.currentTimeMillis() -startTime;
	}
}