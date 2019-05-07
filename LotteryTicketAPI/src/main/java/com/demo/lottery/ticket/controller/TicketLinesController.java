package com.demo.lottery.ticket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.demo.lottery.ticket.jpa.TicketLinesRepository;

@RestController

public class TicketLinesController {
	
	@Autowired
  private TicketLinesRepository ticketLinesRepository;

}
