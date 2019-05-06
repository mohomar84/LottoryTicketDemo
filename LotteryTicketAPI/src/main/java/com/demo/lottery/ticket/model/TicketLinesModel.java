package com.demo.lottery.ticket.model;

import com.demo.lottery.ticket.dao.TicketLines;

public class TicketLinesModel {

	private Long ticket_id;
	private TicketLines ticketlines;
	
	
	public Long getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(Long ticket_id) {
		this.ticket_id = ticket_id;
	}
	public TicketLines getTicketlines() {
		return ticketlines;
	}
	public void setTicketlines(TicketLines ticketlines) {
		this.ticketlines = ticketlines;
	}


	

}
