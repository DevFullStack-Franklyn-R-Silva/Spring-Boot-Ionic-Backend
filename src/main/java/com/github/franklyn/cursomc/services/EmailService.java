package com.github.franklyn.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.github.franklyn.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
	
}
