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
@JsonIgnoreProperties(value = { "id", "ticketFk" }, allowGetters = true)
public class TicketLines {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long ticketFk;

	@NotNull
	// @Pattern(regexp = "[0-2]*")
	private Long lineNo1;

	@NotNull
	@Max(1)
	private Long lineNo2;

	@NotNull
	private Long lineNo3;

	private Long lineSum;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ticketFk", referencedColumnName = "ticketId", insertable = false, updatable = false)
	private Ticket ticket;

	public TicketLines() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTicketFk() {
		return ticketFk;
	}

	public void setTicketFk(Long ticketFk) {
		this.ticketFk = ticketFk;
	}

	public Long getLineNo1() {
		return lineNo1;
	}

	public void setLineNo1(Long lineNo1) {
		this.lineNo1 = lineNo1;
	}

	public Long getLineNo2() {
		return lineNo2;
	}

	public void setLineNo2(Long lineNo2) {
		this.lineNo2 = lineNo2;
	}

	public Long getLineNo3() {
		return lineNo3;
	}

	public void setLineNo3(Long lineNo3) {
		this.lineNo3 = lineNo3;
	}

	public Long getLineSum() {
		return lineSum;
	}

	public void setLineSum(Long lineSum) {
		this.lineSum = lineSum;
	}

}
