package projeto.spring.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import projeto.spring.model.Endereco;

//client cliado via OpenFeign para consumir a API do ViaCep
// www.viacep.com.br


@FeignClient(name = "viacep", url= "https://viacep.com.br/ws")
public interface ViaCepService {

	//Pderia usar a anotação assim:
	//@GetMapping("/{cep}/json")
	@RequestMapping(method = RequestMethod.GET, value = "/{cep}/json/")	
	Endereco consultarCep(@PathVariable("cep") String cep);
	
	
}
