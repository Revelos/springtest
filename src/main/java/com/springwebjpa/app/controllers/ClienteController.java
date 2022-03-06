package com.springwebjpa.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springwebjpa.app.models.entity.Cliente;
import com.springwebjpa.app.models.service.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de Clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		model.put("titulo", "Formulario de Cliente");
		model.put("cliente", cliente);
		return "form";
	}

	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(@Valid Cliente cliente, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cliente");
			return "form";
		}
		if(clienteService.findByDui(cliente.getDui())==null) {
			clienteService.save(cliente);
			status.setComplete();
			flash.addFlashAttribute("success", "Cliente creado con exito");
			return "redirect:listar";
		}
		model.addAttribute("warning", "Una cuenta con ese numero de DUI ya existe");
		return "form";
	}

	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value = "id") Integer id, RedirectAttributes flash) {
		if(id>0) {
			clienteService.delete(id);
		}
		flash.addFlashAttribute("success", "Cliente eliminado con exito");
		return "redirect:/";
	}
	
	//MICROSERVICIO
	@GetMapping(value = "/servicio/{dui}", produces=  {"application/json"})
	public @ResponseBody Cliente getCuenta(@PathVariable String dui,Model model) {
		return clienteService.findByDui(dui);
	}
}
