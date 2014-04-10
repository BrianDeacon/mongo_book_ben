package com.navelplace.ben.exception;

public class InvalidIdException extends RuntimeException
{
	private static final long serialVersionUID = 6958718348455825658L;

	public InvalidIdException(String id, Class<?> clazz) {
		super(String.format("%s is not a valid id for class %s", id, clazz.getName()));
	}
}

