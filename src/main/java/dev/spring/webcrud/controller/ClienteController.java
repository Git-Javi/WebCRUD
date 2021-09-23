package dev.spring.webcrud.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.spring.webcrud.entity.Cliente;
import dev.spring.webcrud.exception.NotFoundCrudException;
import dev.spring.webcrud.service.ClienteService;


@Controller // http://localhost:8080/webcrud/
@RequestMapping(value = "/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	// ----------------------------- LIST (index) -----------------------------
	
	@GetMapping("/list")
	public String listClientesAction(Model model) {
		ArrayList<Cliente> clientes = clienteService.listClientes();
		model.addAttribute("clientes", clientes);
		clientes.stream().forEach(cliente -> System.out.println("LIST: Cliente a mostrar --> "+ cliente.toString()));
		return "index";
	}
	
	// PUEDE HACERSE TAMBIÉN CON ModelAndView QUE ES UNA CLASE MAS ANTIGUA EN LA QUE SE ENCAPSULA TANTO EL NOMBRE LÓGICO DE LA VISTA
	// COMO EL MODELO CON LOS RESULTADOS DE LA OPERACIÓN REALIZADA.
	// EL MODELO ES SIMPLEMENTE UN MAP EN EL QUE PODEMOS IR AÑADIENDO OBJETOS PARA LUEGO ACCEDER A ELLOS POR EL MISMO NOMBRE EN LA VISTA
	// @GetMapping("/lista")
	// public ModelAndView getListaClientes() { 
//		 ArrayList<Cliente> clientes = clienteService.readAll(); 
//		 ModelAndView mav = new ModelAndView();
//		 mav.setViewName("lista-clientes"); mav.addObject("clientes",clientes);
//		 clientes.stream().forEach(cliente->System.out.println(cliente.toString())); 
//		 return mav; 
	// }

	// ----------------------------- CREATE -----------------------------

	@GetMapping("/create")
	public String createClienteFormData(Model model) {
		Cliente unCliente = new Cliente();
		model.addAttribute("cliente", unCliente);
		System.out.println("CREATE: Form solucitado.");
		return "dataForm";
	}

	@PostMapping("/data/actionSubmit")
	public String createClienteAction(@ModelAttribute("cliente") Cliente unCliente) {
		System.out.println("CREATE: Cliente recibido --> " + unCliente);
		clienteService.createCliente(unCliente);
		System.out.println("CREATE: Cliente creado.");
		return "redirect:/";
	}

	// ----------------------------- READ -----------------------------

	@GetMapping("/read/searchById")
	public String readClienteIdForm() {
		System.out.println("READ: Form solucitado.");
		return "searchByIdForm";
	}
	
	@PostMapping("/read/searchById/data")
	public String readClienteFormData(Model model, @RequestParam(value = "id") Long id) {
		System.out.println("READ: ID de cliente recibido --> " + id);
		try {
			Cliente unCliente = clienteService.readClienteById(id);
			model.addAttribute("cliente", unCliente);
			System.out.println("READ: Cliente a mostrar para lectura--> " + unCliente);
			return "dataForm";
		} catch (NotFoundCrudException nfce) {
			return "resourceNotFound";
		}
	}
	
	@PostMapping("/read/searchById/data/actionSubmit")
	public String readClienteAction() {
		System.out.println("READ: Redirección al index.");
		return "redirect:/";
	}

	// ----------------------------- UPDATE -----------------------------
	
	@GetMapping("/update/byId/{id}")
	public String updateClienteFromList(Model model, @PathVariable(value = "id") Long id) {
		System.out.println("UPDATE: ID de cliente recibido --> " + id);
		try {
			Cliente unCliente = clienteService.readClienteById(id);
			model.addAttribute("cliente", unCliente);
			System.out.println("UPDATE: Cliente a mostrar --> " + unCliente);
			return "dataForm";
		} catch (NotFoundCrudException nfce) {
			return "resourceNotFound";
		}
	}
	
	@PostMapping("/update/byId/data/actionSubmit")
	public String updateClienteFromListAction(@ModelAttribute("cliente") Cliente unCliente) {
		clienteService.updateClienteById(unCliente.getId(), unCliente);
		System.out.println("UPDATE: Cliente actualizado --> " + unCliente);
		return "redirect:/";
	}

	@GetMapping("/update/searchById")
	public String updateClienteIdForm() {
		System.out.println("UPDATE: Form solucitado.");
		return "searchByIdForm";
	}
	
	@PostMapping("/update/searchById/data")
	public String updateClienteFormData(Model model, @RequestParam(value = "id") Long id) {
		System.out.println("UPDATE: ID de cliente recibido --> " + id);
		try {
			Cliente unCliente = clienteService.readClienteById(id);
			model.addAttribute("cliente", unCliente);
			System.out.println("UPDATE: Cliente a mostrar para actualizar --> " + unCliente);
			return "dataForm";
		} catch (NotFoundCrudException nfce) {
			return "resourceNotFound";
		}
	}
	
	@PostMapping("/update/searchById/data/actionSubmit")
	public String updateClienteAction(@ModelAttribute("cliente") Cliente unCliente) {
		clienteService.updateClienteById(unCliente.getId(), unCliente);
		System.out.println("UPDATE: Cliente actualizado --> " + unCliente);
		return "redirect:/";
	}


	// ----------------------------- DELETE -----------------------------

	@GetMapping("/delete/byId/{id}")
	public String deleteClienteFromList(@PathVariable(value = "id") Long id) {
		clienteService.deleteClienteById(id);
		System.out.println("DELETE: ID de cliente eliminado --> " + id);
		return "redirect:/";
	}
	
	@GetMapping("/delete/searchById")
	public String deleteClienteIdForm() {
		System.out.println("DELETE: Form solucitado.");
		return "searchByIdForm";
	}

	@PostMapping("/delete/searchById/data")
	public String deleteClienteFormData(Model model, @RequestParam(value = "id") Long id) {
		System.out.println("DELETE: ID de cliente recibido --> " + id);
		try {
			Cliente unCliente = clienteService.readClienteById(id);
			model.addAttribute("cliente", unCliente);
			System.out.println("DELETE: Cliente a mostrar para eliminar --> " + unCliente);
			return "dataForm";
		} catch (NotFoundCrudException nfce) {
			return "resourceNotFound";
		}
	}
	
	@PostMapping("/delete/searchById/data/actionSubmit")
	public String deleteClienteAction(@RequestParam(value = "id") Long id) {
		clienteService.deleteClienteById(id);
		System.out.println("DELETE: ID de cliente eliminado --> " + id);
		return "redirect:/";
	}
}
