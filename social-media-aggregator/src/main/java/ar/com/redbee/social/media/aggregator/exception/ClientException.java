package ar.com.redbee.social.media.aggregator.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * ClientException representa una excepcion producida al consumir un cliente web
 * service.
 *
 */
public class ClientException extends Exception {

	private static final long serialVersionUID = -3335859349640344866L;

	private String errorCode;

	public ClientException(final String message) {
		super(message);
	}

	public ClientException(final String message, final String errorCode) {
		super(message);
		setErrorCode(errorCode);
	}

	public ClientException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ClientException(final String message, final String errorCode, final Throwable cause) {
		super(message, cause);
		setErrorCode(errorCode);
	}

	public boolean hasErrorCode() {
		return !StringUtils.isBlank(getErrorCode());
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(final String errorCode) {
		this.errorCode = errorCode;
	}

}
