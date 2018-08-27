package ar.com.redbee.social.media.aggregator.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * ServiceException representa una excepcion producida en la capa de servicio.
 *
 */
public class ServiceException extends Exception {

	private static final long serialVersionUID = -3335859349640344866L;

	private String errorCode;

	public ServiceException(final String message) {
		super(message);
	}

	public ServiceException(final String message, final String errorCode) {
		super(message);
		setErrorCode(errorCode);
	}

	public ServiceException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ServiceException(final String message, final String errorCode, final Throwable cause) {
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
