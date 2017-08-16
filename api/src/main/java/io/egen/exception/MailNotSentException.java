package io.egen.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class MailNotSentException extends RuntimeException {
	public MailNotSentException(String message) {
		super(message);
	}
}
