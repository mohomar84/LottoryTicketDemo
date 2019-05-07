package com.demo.lottery.ticket.controller;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.lottery.ticket.constant.LottoryConstant;
import com.demo.lottery.ticket.dao.Ticket;
import com.demo.lottery.ticket.dao.TicketLines;
import com.demo.lottery.ticket.exception.ResourceNotFoundException;
import com.demo.lottery.ticket.jpa.TicketRepository;
import com.demo.lottery.ticket.services.TicketServices;

@RestController
@RequestMapping("/lottory")
public class TicketController {

	@Autowired
	private TicketRepository ticketRepository;

	@GetMapping("/ticket")
	public @ResponseBody List<Ticket> getAllTickets() {
		return ticketRepository.findAll();
	}

	@GetMapping("/ticket/{id}")
	public Optional<Ticket> getTicketByTicketId(@PathVariable(value = "id") Long ticketId)
			throws ResourceNotFoundException {
		return ticketRepository.findById(ticketId);

	}
	
	@PostMapping("/ticket")
	public String createTodo(@Valid @RequestBody Ticket ticket) {
		ticket.setTicketStatus(LottoryConstant.lottory_status_unchecked);
		for (int i = 0; i < ticket.getTicketLines().size(); i++) {
			 ticket.getTicketLines().get(i);
			 ticket.getTicketLines().get(i).setTicketFk(ticket.getTicketId());
			 TicketServices ticketnumber = new TicketServices();
			 long ticketnumberSum = ticketnumber.ticketRoles(ticket.getTicketLines().get(0).getLineNo1(),
					 ticket.getTicketLines().get(0).getLineNo2(),
					 ticket.getTicketLines().get(0).getLineNo3());
			 ticket.getTicketLines().get(i).setLineSum(ticketnumberSum);
		}
		ticketRepository.save(ticket);
		
	    return "Ticket Add";
	}
	
	@PutMapping("/ticket/{id}")
	public Ticket updateTicket(@PathVariable(value = "id") Long id,
	                                        @Valid @RequestBody Ticket ticketDetails) {

		Ticket ticket = ticketRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException( id));

		ticket.setTicketStatus(ticketDetails.getTicketStatus());

		return ticketRepository.save(ticket);

	}
	
	@PutMapping("/status/{id}")
	public String updateStatus(@PathVariable(value = "id") Long id,
	                                        @Valid @RequestBody Ticket ticketDetails) {

		Ticket ticket = ticketRepository.findById(id)
	            .orElseThrow(() -> new ResourceNotFoundException( id));
		if (ticket.getTicketStatus() == LottoryConstant.lottory_status_unchecked) {
			
			ticket.setTicketStatus(LottoryConstant.lottory_status_checked);
			ticketRepository.save(ticket);
		}

		return ticket.getTicketStatus();

	}
	

}
