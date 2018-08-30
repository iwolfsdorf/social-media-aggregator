package ar.com.redbee.social.media.aggregator.exception.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import java.io.Serializable;
import java.time.LocalDateTime;

@JsonInclude(Include.NON_NULL)
public class RestError implements Serializable {

	private static final long serialVersionUID = -7681147594906649384L;

	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime timestamp;
	private Integer status;
	private String error;
	private String message;

	public RestError() {
		timestamp = LocalDateTime.now();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
