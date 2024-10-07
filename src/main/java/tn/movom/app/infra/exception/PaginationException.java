package tn.movom.app.infra.exception;

public class PaginationException extends RuntimeException {
	
	public PaginationException() {
		super("Pagination is wrong");
	}
	
	public PaginationException(String message) {
		super(message);
	}
	
}



