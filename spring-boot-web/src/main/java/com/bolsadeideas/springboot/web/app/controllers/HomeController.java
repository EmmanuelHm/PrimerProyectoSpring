package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		
		/* Retorno automatico hacia otro controlador/vista */
		
		/* Redirect cambia la ruta URL*/
		//return "redirect:/app/index";
		
		/*Forward mantiene la ruta en el navegador (URL)*/
		return "forward:/app/index";
		
		/* Redireccionando automaticamente a Google */
		//return "redirect:https://google.com/";
		
	}

}
