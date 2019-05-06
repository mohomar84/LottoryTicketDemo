package com.demo.lottery.ticket.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.lottery.ticket.dao.Ticket;


@Repository

public interface TicketRepository extends JpaRepository<Ticket, Long>{
	

}
