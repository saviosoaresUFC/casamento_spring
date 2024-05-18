package springbootintellij.casamento.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springbootintellij.casamento.modelo.ProdutoModelo;

import java.util.UUID;

@Repository
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, UUID>{

}
