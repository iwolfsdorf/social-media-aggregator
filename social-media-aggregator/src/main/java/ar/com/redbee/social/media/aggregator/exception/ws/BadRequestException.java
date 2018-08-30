package ar.com.redbee.social.media.aggregator.exception.ws;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RestControllerException {

	private static final long serialVersionUID = -8047367734157864376L;

	public BadRequestException() {
		super("Peticion incorrecta", HttpStatus.BAD_REQUEST);
	}

	public BadRequestException(final String message) {
		super(message, HttpStatus.BAD_REQUEST);
	}

}
