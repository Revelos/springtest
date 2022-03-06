package com.springwebjpa.app.controllers;

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
import com.springwebjpa.app.models.entity.Cuenta;
import com.springwebjpa.app.models.entity.Transaccion;
import com.springwebjpa.app.models.service.IClienteService;
import com.springwebjpa.app.models.service.ICuentaService;
import com.springwebjpa.app.models.service.ITipoTransaccion;
import com.springwebjpa.app.models.service.ITransaccionService;

@Controller
@SessionAttributes("cuenta")
public class CuentaController {

	@Autowired
	private ICuentaService cuentaService;
	
	@Autowired
	private IClienteService clienteService;
	
	@Autowired
	private ITipoTransaccion tipoTransaccion;
	
	@Autowired
	private ITransaccionService transaccionService;
	
	@RequestMapping(value = "/nuevaCuenta/{id}")
	public String crear(@PathVariable(value = "id") Integer id,Model model) {
		Cuenta cuenta = new Cuenta();
		cuenta.setCod_cliente(clienteService.findOne(id));
		model.addAttribute("cuenta", cuenta); 
		return "formCuenta";
	}
	
	//Metodo para guardar cuenta
	@RequestMapping(value="/nuevaCuenta", method=RequestMethod.POST)
	public String guardar(@Valid Cuenta cuenta, BindingResult result, Model model, RedirectAttributes flash, SessionStatus status) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Cuenta");
			return "formCuenta";
		}
		
		cuentaService.save(cuenta);
		status.setComplete();
		flash.addFlashAttribute("success", "Cliente creado con exito");
		return "redirect:listar";
	}
	
	@RequestMapping(value="/nuevaTransaccion", method=RequestMethod.POST)
	public String guardartransa(@Valid Transaccion transa, BindingResult result,Model model, RedirectAttributes flash) {
		if (result.hasErrors()) {
			model.addAttribute("titulo", "Formulario de Transaccion");
			return "modal";
		}
		transaccionService.save(transa);
		flash.addFlashAttribute("success", "Transaccion registrada con exito");
		return "redirect:listar";
		
	}
	
	//Metodo que obtiene las cuentas dado un id del cliente
	@RequestMapping(value = "/transaccion/{id}")
	public String getCuentas(@PathVariable(value = "id") Integer id,Model model) {
		Cliente cliente = new Cliente();
		cliente = clienteService.findOne(id);
		Transaccion transa = new Transaccion();
		model.addAttribute("titulo","Formulario de Transaccion");
		model.addAttribute("cliente", cliente); 
		model.addAttribute("tipos", tipoTransaccion.findAll());
		model.addAttribute("transaccion",transa);
		return "modal";
	}

	//Metodo que obtiene el saldo de la cuenta
	@GetMapping(value = "/getCuenta/{id}", produces= {"application/json"})
	public @ResponseBody String getCuenta(@PathVariable String id,Model model) {
		Cuenta cuenta = new Cuenta();
		cuenta = cuentaService.findOne(id);
		
		return String.valueOf(cuenta.getSaldo());
	}
	
}
