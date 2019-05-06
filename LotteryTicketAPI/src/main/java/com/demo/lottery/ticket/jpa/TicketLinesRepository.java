package com.demo.lottery.ticket.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.lottery.ticket.dao.TicketLines;

@Repository

public interface TicketLinesRepository extends JpaRepository<TicketLines,Long>{
//	Page<Comment> findByPostId(Long postId, Pageable pageable);
//    Optional<Comment> findByIdAndPostId(Long id, Long postId);

}
