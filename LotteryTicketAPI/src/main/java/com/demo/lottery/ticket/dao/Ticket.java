package com.demo.lottery.ticket.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;





//@JsonIgnoreProperties(value = { "ticket_id", "ticket_status" })
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticket_id;

	private String ticket_status;

	@OneToMany(mappedBy = "ticket_fk",fetch = FetchType.EAGER)
	private List<TicketLines> ticketLines;

	public Ticket() {

	}

	public Long getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(Long ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getTicket_status() {
		return ticket_status;
	}

	public void setTicket_status(String ticket_status) {
		this.ticket_status = ticket_status;
	}

	public List<TicketLines> getTicketLines() {
		return ticketLines;
	}

	public void setTicketLines(List<TicketLines> ticketLines) {

		this.ticketLines = ticketLines;
	}

}
