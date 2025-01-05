package com.aluracursos.Literalura;

import com.aluracursos.Literalura.Service.ConsumoAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication {

	public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);

		var consumoAPI = new ConsumoAPI();
		var json = consumoAPI.obtenerDatos("https://gutendex.com/books/");
		//System.out.println(json);
	}

}
