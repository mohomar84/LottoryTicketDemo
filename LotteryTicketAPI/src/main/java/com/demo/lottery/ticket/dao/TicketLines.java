package com.demo.lottery.ticket.dao;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
//@JsonIgnoreProperties(value = { "id", "ticket_fk" }, allowGetters = true)
public class TicketLines {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long ticket_fk;

	@NotNull
	// @Pattern(regexp = "[0-2]*")
	private Long line_no_1;

	@NotNull
	@Max(1)
	private Long line_no_2;

	@NotNull
	private Long line_no_3;

	private Long line_sum;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ticket_fk", referencedColumnName = "ticket_id", insertable = false, updatable = false)
	private Ticket ticket;

	public TicketLines() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTicket_fk() {
		return ticket_fk;
	}

	public void setTicket_fk(Long ticket_fk) {

		this.ticket_fk = ticket_fk;
	}

	public Long getLine_no_1() {
		return line_no_1;
	}

	public void setLine_no_1(Long line_no_1) {
		this.line_no_1 = line_no_1;
	}

	public Long getLine_no_2() {
		return line_no_2;
	}

	public void setLine_no_2(Long line_no_2) {
		this.line_no_2 = line_no_2;
	}

	public Long getLine_no_3() {
		return line_no_3;
	}

	public void setLine_no_3(Long line_no_3) {
		this.line_no_3 = line_no_3;
	}

	public Long getLine_sum() {
		return line_sum;
	}

	public void setLine_sum(Long line_sum) {
		this.line_sum = line_sum;
	}

}
