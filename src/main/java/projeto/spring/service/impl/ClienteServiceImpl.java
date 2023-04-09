package projeto.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import projeto.spring.model.Cliente;
import projeto.spring.model.ClienteRepository;
import projeto.spring.model.Endereco;
import projeto.spring.model.EnderecoRepository;
import projeto.spring.service.ClienteService;
import projeto.spring.service.ViaCepService;

import java.util.Optional;

public class ClienteServiceImpl implements ClienteService{
	// Slingleton: Injetar os componentes do Sping com @Autowired
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ViaCepService viaCepService;

	// Strategy: Inplementar os métodos definidos na interface
	// Facade: abstrair integrações com subsistemas, promovendo uma interface simples.

	
	//É obrigatorio implementar todos os métodos da classe ClientService
	@Override
	public Iterable<Cliente>buscarTodos(){
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		//verificar se ja existe o cep
		salvarClientePorCep(cliente);

	}


	@Override
	public void atualizar(Long id, Cliente cliente) {
		//busca se exite
		Optional<Cliente> clienteBd = clienteRepository.findById(id);
		if(clienteBd.isPresent()){
			//Faz o processo de inserir...
			salvarClientePorCep(cliente);

		}
		
	}


	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
		
	}
	//Criamos o metodo para utilizar duas vezes
	private void salvarClientePorCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco =  enderecoRepository.findById(cep).orElseGet(()->{
			//.orElseGet = se nao exitir, consome a api do via cep e salva o novo endereço
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

}
