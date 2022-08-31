package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

//import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.web.app.models.Usuario;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexController.index.titulo:}")
	private String textoIndex; 
	@Value("${texto.indexController.perfil.titulo:}")
	private String textoPerfil;
	@Value("${texto.indexController.listar.titulo:}")
	private String textoListar;
	
	//@RequestMapping(value="/index", method = RequestMethod.GET)
	@GetMapping({"/index", "/", "", "/home"})
	public String index(Model model) {
		//model.addAttribute("titulo", "Hola Spring Framework con Model/ModelMap");
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	/*public String index(Map<String, Object> map) {
		map.put("titulo", "Hola Spring Framework con Map");
		return "index";
	}*/
	
	/*public ModelAndView index(ModelAndView mv) {
		mv.addObject("titulo", "Hola Spring Framework con ModelAndView");
		mv.setViewName("index");
		return mv;
	}*/
	
	/*----------------------------------------------------------*/
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		//Modelo Usuario
		Usuario usuario = new Usuario();
		usuario.setNombre("Emmanuel");
		usuario.setApellido("Hernandez");
		usuario.setEmail("emmanuel@mail.com");
		
		model.addAttribute("usuario", usuario);
		//model.addAttribute("titulo", "Perfil del usuario: ".concat( usuario.getNombre() ) );
		model.addAttribute("titulo", textoPerfil.concat( usuario.getNombre() ) );
		
		//Retorno a la vista
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		
		//Llenar una lista de Usuarios 1
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add( new Usuario("Emmanuel", "Hdez", "emmanuel@mail.com") );
		usuarios.add( new Usuario("Andres", "Guzman", "andres@mail.com") );
		usuarios.add( new Usuario("Ivan", "Maqueda", "ivan@mail.com") );
		usuarios.add( new Usuario("Tornado", "Roe", "roe@mail.com") );
		
		//Llenar una lista de Usuarios 2
		/*List<Usuario> usuarios = Arrays.asList(
				new Usuario("Emmanuel", "Hdez", "emmanuel@mail.com"),
				new Usuario("Andres", "Guzman", "andres@mail.com"),
				new Usuario("Ivan", "Maqueda", "ivan@mail.com"),
				new Usuario("Tornado", "Roe", "roe@mail.com")
		);*/
		
		//model.addAttribute("titulo", "Lista de Usuarios");
		model.addAttribute("titulo", textoListar);
		model.addAttribute("usuarios", usuarios);
		
		return "listar";
	}
	
	/*Para pasar de otra formar la informacion a las vistas*/
	/*La informacion estara disponible para usarse en todas las vistas del controlador */
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Emmanuel", "Hdez", "emmanuel@mail.com"),
				new Usuario("Andres", "Guzman", "andres@mail.com"),
				new Usuario("Ivan", "Maqueda", "ivan@mail.com"),
				new Usuario("Tornado", "Roe", "roe@mail.com")
		);
		
		return usuarios;
	}
	
	
}