package znlipe.com.github.ProjetoVendasAPIEstudos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import znlipe.com.github.ProjetoVendasAPIEstudos.domain.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
