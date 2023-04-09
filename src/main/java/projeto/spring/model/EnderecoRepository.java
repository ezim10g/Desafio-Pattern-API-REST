package projeto.spring.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//CrudRepository é uma Strategy que contem os métodos para fazer o crud
@Repository //esta notação é opcional para entendimento, pois ela ja está extendendo a Classe CrudeRepository
public interface EnderecoRepository extends CrudRepository<Endereco, String>{

}
