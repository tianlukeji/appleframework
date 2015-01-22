package com.appleframework.exception;

/**
 * Base class for all custom exception thrown in AppleFramework
 * 
 * @author Cruise.Xu
 * @date: 2012-10-15
 * 
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = 7696865849245536841L;

	public static final String RSP = "rsp.";

	private Class<?> clazz;

	private String code;

	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ServiceException() {
		super();
	}

	public ServiceException(String code) {
		this.code = code;
	}

	public ServiceException(Class<?> clazz, String code) {
		this.code = code;
		this.clazz = clazz;
	}

	public ServiceException(Class<?> clazz, String code, Throwable throwable) {
		super(code, throwable);
		this.code = code;
	}

	public String getKey() {
		return RSP + transform(clazz.getDeclaringClass().getName()) + ":"
				+ getCode();
	}

	public String getMessage() {
		return message;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	/**
	 * 对服务名进行标准化处理：如book.upload转换为book-upload，
	 * 
	 * @param method
	 * @return
	 */
	public String transform(String className) {
		if (className != null) {
			className = className.replace(".", "-");
			return className;
		} else {
			return "LACK_METHOD";
		}
	}

}
