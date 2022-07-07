package znlipe.com.github.ProjetoVendasAPIEstudos.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import znlipe.com.github.ProjetoVendasAPIEstudos.domain.entity.Produto;

import javax.validation.Valid;


public interface ProdutoAPI {

    ResponseEntity<Void> inserirProduto(@RequestBody @Valid Produto produto);
}
