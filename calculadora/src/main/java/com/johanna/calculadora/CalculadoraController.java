package com.johanna.calculadora;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calc")
public class CalculadoraController {

    // GET e POST para soma
    @RequestMapping(value = "/soma", method = {RequestMethod.GET, RequestMethod.POST})
    public double somar(@RequestParam double x, @RequestParam double y) {
        return x + y;
    }

    // GET e POST para subtrair
    @RequestMapping(value = "/subtrair", method = {RequestMethod.GET, RequestMethod.POST})
    public double subtrair(@RequestParam double x, @RequestParam double y) {
        return x - y;
    }

    // GET e POST para multiplicar
    @RequestMapping(value = "/multiplicar", method = {RequestMethod.GET, RequestMethod.POST})
    public double multiplicar(@RequestParam double x, @RequestParam double y) {
        return x * y;
    }

    // GET e POST para dividir
    @RequestMapping(value = "/dividir", method = {RequestMethod.GET, RequestMethod.POST})
    public double dividir(@RequestParam double x, @RequestParam double y) {
        if (y == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        return x / y;
    }

    // GET e POST para potencia
    @RequestMapping(value = "/potencia", method = {RequestMethod.GET, RequestMethod.POST})
    public double potencia(@RequestParam double x, @RequestParam double y) {
        return Math.pow(x, y);
    }

    // Tratamento de exceções do tipo IllegalArgumentException
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleIllegalArgument(IllegalArgumentException e) {
        return e.getMessage();
    }


}
