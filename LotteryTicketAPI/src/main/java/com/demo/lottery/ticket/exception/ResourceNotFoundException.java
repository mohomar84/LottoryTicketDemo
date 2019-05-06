package com.demo.lottery.ticket.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	
	public ResourceNotFoundException( long id) {
    	super(String.format("The Ticket is not found with the number : '%s'", id));

    }

}
