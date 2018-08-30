package ar.com.redbee.social.media.aggregator.exception.ws;

import org.springframework.http.HttpStatus;

public abstract class RestControllerException extends RuntimeException {

	private static final long serialVersionUID = 2198512035951702118L;

	private HttpStatus status;

	public RestControllerException() {
	}

	public RestControllerException(final String message, final HttpStatus status) {
		super(message);
		setStatus(status);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(final HttpStatus status) {
		this.status = status;
	}

}
