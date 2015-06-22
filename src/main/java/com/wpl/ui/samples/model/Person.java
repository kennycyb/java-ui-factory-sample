package com.wpl.ui.samples.model;

import java.io.Serializable;

public class Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String mFirstName;
	private String mLastName;

	public String getFirstName() {
		return mFirstName;
	}

	public void setFirstName(String mFirstName) {
		this.mFirstName = mFirstName;
	}

	public String getLastName() {
		return mLastName;
	}

	public void setLastName(String mLastName) {
		this.mLastName = mLastName;
	}
}
