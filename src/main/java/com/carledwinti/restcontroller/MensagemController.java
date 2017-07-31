package com.carledwinti.restcontroller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carledwinti.model.Mensagem;

@RestController
public class MensagemController {

	private static final String template = "Olá, %s!";
	
	private final AtomicLong counter = new AtomicLong();
	//http://localhost:8080/mensagem >> {"id":1,"texto":"Olá, Carl Edwin!"}
	//http://localhost:8080/mensagem?name=Fulano de Tal >> {"id":2,"texto":"Olá, Fulano de Tal!"}
	@RequestMapping("/mensagem")
	public Mensagem mensagem(@RequestParam(value="name", defaultValue="Carl Edwin") String name){
		return new Mensagem(counter.incrementAndGet(), String.format(template, name));
	}
}
