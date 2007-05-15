package com.mutation.runner;

import java.util.Set;

import com.mutation.runner.utililties.ToStringUtils;

public class ClassDescription {

	private String className;

	private String packageName;

	private String classFile;
	
	private String sourceFile;

	private Set<String> associatedTestNames;

	public String getClassFile() {
		return classFile;
	}

	public void setClassFile(String classFile) {
		this.classFile = classFile;
	}

	/**
	 * 
	 * @return local class name withou package name
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * 
	 * @return class name inclusive package prefix
	 */
	public String getQualifiedClassName() {
		return packageName == null ? className : packageName + "." + className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	@Override
	public String toString() {
		return ToStringUtils.toString(this);
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public Set<String> getAssociatedTestNames() {
		return associatedTestNames;
	}

	public void setAssociatedTestNames(Set<String> associatedTestNames) {
		this.associatedTestNames = associatedTestNames;
	}

	public String getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(String sourceFile) {
		this.sourceFile = sourceFile;
	}
}