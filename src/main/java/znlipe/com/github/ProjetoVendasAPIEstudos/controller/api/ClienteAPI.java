package znlipe.com.github.ProjetoVendasAPIEstudos.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import znlipe.com.github.ProjetoVendasAPIEstudos.domain.entity.Cliente;

import javax.validation.Valid;

public interface ClienteAPI {

    ResponseEntity<Void> inserirCliente (@RequestBody @Valid Cliente cliente);
}
