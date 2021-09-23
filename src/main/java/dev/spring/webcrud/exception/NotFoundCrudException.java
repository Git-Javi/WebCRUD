package dev.spring.webcrud.exception;

public class NotFoundCrudException extends CrudException {

	private static final long serialVersionUID = 1L;

	public NotFoundCrudException(String msg) {
		super(msg);
	}
}
