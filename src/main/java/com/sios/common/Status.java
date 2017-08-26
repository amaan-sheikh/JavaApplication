package com.sios.common;

public class Status {

	private short responseCode;
	private String responseMessage;
	private Object responseBody;

	private byte requestMethod;

	public byte getRequestMethod() {
		return requestMethod;
	}

	

	public void setRequestMethod(byte requestMethod) {
		this.requestMethod = requestMethod;
	}

		public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public Object getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(Object responseBody) {
		this.responseBody = responseBody;
	}



	public short getResponseCode() {
		return responseCode;
	}



	public void setResponseCode(short responseCode) {
		this.responseCode = responseCode;
	}
	
	

}
