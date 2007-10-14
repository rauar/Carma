package com.retroduction.carma.report.generator.reportobjects;

import java.util.List;

public class ClassInfo {
	private String fqClassName;
	private double surviverRatio;
	private int numMutants;
	private int numSurvivors;
	private List<String> tests;
	public ClassInfo(String fqClassName, int numMutants, int numSurvivors, List<String> tests) {
		super();
		this.fqClassName = fqClassName;
		this.numMutants = numMutants;
		this.numSurvivors = numSurvivors;
		this.tests = tests;
		
		this.surviverRatio = numMutants == 0 ? 0.0 : (double) numSurvivors / (double) numMutants;
	}
	public String getFqClassName() {
		return this.fqClassName;
	}
	public int getNumMutants() {
		return this.numMutants;
	}
	public int getNumSurvivors() {
		return this.numSurvivors;
	}
	public double getSurviverRatio() {
		return this.surviverRatio;
	}
	public double getMCoverageRatio() {
		return 1.0 -this.surviverRatio;
	}
	public List<String> getTests() {
		return this.tests;
	}
}