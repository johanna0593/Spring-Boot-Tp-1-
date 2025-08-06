package com.example.calculadora_cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@RestController
	@RequestMapping("/calc")
	public static class CalculadoraController {

		@RequestMapping(value = "/soma", method = {RequestMethod.GET, RequestMethod.POST})
		public double somar(@RequestParam double x, @RequestParam double y) {
			return x + y;
		}

		@RequestMapping(value = "/subtrair", method = {RequestMethod.GET, RequestMethod.POST})
		public double subtrair(@RequestParam double x, @RequestParam double y) {
			return x - y;
		}

		@RequestMapping(value = "/multiplicar", method = {RequestMethod.GET, RequestMethod.POST})
		public double multiplicar(@RequestParam double x, @RequestParam double y) {
			return x * y;
		}

		@RequestMapping(value = "/dividir", method = {RequestMethod.GET, RequestMethod.POST})
		public double dividir(@RequestParam double x, @RequestParam double y) {
			if (y == 0) {
				throw new IllegalArgumentException("Não é possível dividir por zero.");
			}
			return x / y;
		}

		@RequestMapping(value = "/potencia", method = {RequestMethod.GET, RequestMethod.POST})
		public double potencia(@RequestParam double x, @RequestParam double y) {
			return Math.pow(x, y);
		}

		@ExceptionHandler(IllegalArgumentException.class)
		@ResponseStatus(HttpStatus.BAD_REQUEST)
		public String handleIllegalArgument(IllegalArgumentException e) {
			return e.getMessage();
		}
	}
}
