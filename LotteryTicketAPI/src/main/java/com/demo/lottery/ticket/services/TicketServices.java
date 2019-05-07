package com.demo.lottery.ticket.services;

public class TicketServices {
	
public long ticketRoles(long num1 , long num2 ,long num3) {
		
		if(num1 + num2 + num3 == 2) {
			return 10 ;
		}
		else if (num1 == num2 && num2 == num3 )
		{
			return 5;
		}
		else if (num1 != num3 && num1 == num2)
		{
			return 1;
		}
		else 
		{
		return 0;
		}
	}

}
