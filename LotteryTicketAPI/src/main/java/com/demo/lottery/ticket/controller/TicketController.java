package com.demo.lottery.ticket.controller;

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
	public Ticket createTodo(@Valid @RequestBody Ticket ticket) {
		ticket.setTicketStatus(LottoryConstant.lottory_status_unchecked);
		
	    return ticketRepository.save(ticket);
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

		return ticket.getTicketStatus();

	}
	

}
