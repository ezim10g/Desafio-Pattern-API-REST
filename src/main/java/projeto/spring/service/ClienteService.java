package projeto.spring.service;

import projeto.spring.model.Cliente;

/*
* No pacote service
*implementamos os metodos de complexidade de 
*crud
*
* */ 


public interface ClienteService {
	
	public Iterable<Cliente> buscarTodos();
	public Cliente buscarPorId(Long id);
	public void inserir(Cliente cliente);
	public void atualizar(Long id, Cliente cliente);
	public void deletar(Long id);

}
