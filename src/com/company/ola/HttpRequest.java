package com.company.ola;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HttpRequest implements Serializable{
	private static final long serialVersionUID = -2525765856387203051L;
	private static volatile int KeyCounter = 0;
	private int id;
	private String url;
	private String header;
	private String bodyObject;
	private int expectedResponseCode;
	private Status status;
	private State state;
	private int firstResponseStatus;
	private int noOfRetry;
	private List<Integer> retryResponseStatus;

	public HttpRequest() {
	}

	public HttpRequest(String url, String header, String bodyObject, int expectedResponseCode) {
		this.id = ++KeyCounter;
		this.url = url;
		this.header = header;
		this.bodyObject = bodyObject;
		this.expectedResponseCode = expectedResponseCode;
		this.status = Status.INQUEUE;;
		this.state = State.UNCOMPLETE;
		this.retryResponseStatus = new ArrayList<Integer>();
	}

	@Override
	public String toString() {
		return "HttpRequest [id=" + id + ", url=" + url + ", header=" + header
				+ ", bodyObject=" + bodyObject + ", expectedResponseCode="
				+ expectedResponseCode + ", status=" + status + ", state="
				+ state + ", firstResponseStatus=" + firstResponseStatus
				+ ", noOfRetry=" + noOfRetry + ", retryResponseStatus="
				+ retryResponseStatus + "]";
	}
	
	public String toShortString() {
		return "id=" + id + ", status=" + status + ", state=" + state ;
	}

	protected Object readResolve() {
		return new HttpRequest();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getBodyObject() {
		return bodyObject;
	}
	public void setBodyObject(String bodyObject) {
		this.bodyObject = bodyObject;
	}
	public int getExpectedResponseCode() {
		return expectedResponseCode;
	}
	public void setExpectedResponseCode(int expectedResponseCode) {
		this.expectedResponseCode = expectedResponseCode;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public int getFirstResponseStatus() {
		return firstResponseStatus;
	}
	public void setFirstResponseStatus(int firstResponseStatus) {
		this.firstResponseStatus = firstResponseStatus;
	}
	public int getNoOfRetry() {
		return noOfRetry;
	}
	public void setNoOfRetry(int noOfRetry) {
		this.noOfRetry = noOfRetry;
	}
	public List<Integer> getRetryResponseStatus() {
		return retryResponseStatus;
	}
	public void setRetryResponseStatus(List<Integer> retryResponseStatus) {
		this.retryResponseStatus = retryResponseStatus;
	}
}
