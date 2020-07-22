package com.startaideia.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.startaideia.desafio.security.AccountCredentials;

import io.swagger.annotations.ApiOperation;

@SpringBootApplication
@RestController
public class ToolServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToolServiceApplication.class, args);
	}
	
	@PostMapping("/sign-up")
	@ApiOperation(value = "Recupera o token (header da resposta) através das credenciais enviadas")
 	public void signUp(@RequestBody AccountCredentials credentials) { 	}

}
