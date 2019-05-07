package com.demo.lottery.ticket.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;





@JsonIgnoreProperties(value = { "ticket_id", "ticket_status" })
@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ticketId;

	private String ticketStatus;

	@OneToMany(mappedBy = "ticketFk",fetch = FetchType.EAGER)
	private List<TicketLines> ticketLines;

	public Ticket() {

	}


	public Long getTicketId() {
		return ticketId;
	}



	public void setTicketId(Long ticketId) {
		this.ticketId = ticketId;
	}



	public String getTicketStatus() {
		return ticketStatus;
	}



	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}



	public List<TicketLines> getTicketLines() {
		return ticketLines;
	}

	public void setTicketLines(List<TicketLines> ticketLines) {

		this.ticketLines = ticketLines;
	}

}
