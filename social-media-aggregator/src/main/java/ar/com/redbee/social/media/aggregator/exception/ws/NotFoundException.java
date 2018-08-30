package ar.com.redbee.social.media.aggregator.exception.ws;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RestControllerException {

	private static final long serialVersionUID = 3059391090321422706L;

	public NotFoundException() {
		super("Recurso no encontrado", HttpStatus.NOT_FOUND);
	}

	public NotFoundException(final String message) {
		super(message, HttpStatus.NOT_FOUND);
	}

}
