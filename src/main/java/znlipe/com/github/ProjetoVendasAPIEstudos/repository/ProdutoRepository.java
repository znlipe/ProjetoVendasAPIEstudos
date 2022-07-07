package znlipe.com.github.ProjetoVendasAPIEstudos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import znlipe.com.github.ProjetoVendasAPIEstudos.domain.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
