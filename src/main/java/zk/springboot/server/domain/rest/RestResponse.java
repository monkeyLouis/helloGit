package zk.springboot.server.domain.rest;

public class RestResponse<T> {
	private Integer status;
	private String message;
	private T data;
	
	public RestResponse(){ }
	
	public RestResponse(Integer status, String message, T data){
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
