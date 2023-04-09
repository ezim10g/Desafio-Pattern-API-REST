package projeto.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projeto.spring.model.Cliente;
import projeto.spring.service.ClienteService;

@RestController
@RequestMapping(value = "clientes")
public class ClienteRestController {

	@Autowired(required = false)
	private ClienteService clienteService;
	
	@GetMapping
	public String home() {
		return "Inicio da API";
	}
	
	@GetMapping(value = "/buscar")
	public ResponseEntity<Iterable<Cliente>> buscarTodos(){
		if(this.clienteService != null) {
			return ResponseEntity.ok(clienteService.buscarTodos());
		}else return null;
		
	}
	
	@GetMapping(value = "/buscar/{id}")
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
		return ResponseEntity.ok(clienteService.buscarPorId(id));
	}
	
	@PostMapping(value = "/inserir")
	public ResponseEntity<Cliente> inserir(@RequestAttribute Cliente cliente){
		clienteService.inserir(cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping(value = "/atualizar/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
		clienteService.atualizar(id ,cliente);
		return ResponseEntity.ok(cliente);
	}
	
	@PutMapping(value = "/deletar/{id}")
	public ResponseEntity<Cliente> deletar(@PathVariable Long id){
		clienteService.deletar(id);
		return ResponseEntity.ok().build();
	}
	
}
