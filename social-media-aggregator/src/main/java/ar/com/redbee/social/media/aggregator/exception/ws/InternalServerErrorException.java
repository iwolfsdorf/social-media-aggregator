package ar.com.redbee.social.media.aggregator.exception.ws;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class InternalServerErrorException extends RestControllerException {

	private static final long serialVersionUID = -2578109852468740781L;

	public InternalServerErrorException() {
		super("Error del servidor", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	public InternalServerErrorException(final String message) {
		super(message, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
