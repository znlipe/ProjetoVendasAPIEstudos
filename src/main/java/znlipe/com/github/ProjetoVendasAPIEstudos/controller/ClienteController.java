package znlipe.com.github.ProjetoVendasAPIEstudos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import znlipe.com.github.ProjetoVendasAPIEstudos.controller.api.ClienteAPI;
import znlipe.com.github.ProjetoVendasAPIEstudos.domain.dto.ClienteDto;
import znlipe.com.github.ProjetoVendasAPIEstudos.domain.entity.Cliente;
import znlipe.com.github.ProjetoVendasAPIEstudos.repository.ClienteRepository;
import znlipe.com.github.ProjetoVendasAPIEstudos.service.ClienteService;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController implements ClienteAPI {

    @Autowired
    private ClienteRepository clienteRepository;

    private ClienteService clienteService;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> inserirCliente(@RequestBody @Valid Cliente cliente){
        clienteService.inserirCliente(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    ResponseEntity<Void> updateCliente(@PathVariable Integer id, @Valid @RequestBody ClienteDto clienteDto){
        Cliente cliente = clienteService.fromDto(clienteDto);
        cliente.setId(id);
        clienteService.updateCliente(cliente);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<Cliente> findCliente(@PathVariable Integer id){
        Cliente cliente = clienteService.find(id);
        return ResponseEntity.ok().body(cliente);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Void> deletCliente(@PathVariable Integer id){
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<Cliente>> findAll(){
        List<Cliente> list = clienteService.findAll();
        return ResponseEntity.ok().body(list);
    }


}
