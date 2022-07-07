package znlipe.com.github.ProjetoVendasAPIEstudos.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import znlipe.com.github.ProjetoVendasAPIEstudos.domain.dto.ClienteDto;
import znlipe.com.github.ProjetoVendasAPIEstudos.domain.entity.Cliente;
import znlipe.com.github.ProjetoVendasAPIEstudos.exception.ObjectNotFoundException;
import znlipe.com.github.ProjetoVendasAPIEstudos.repository.ClienteRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente inserirCliente(Cliente cliente){
        cliente.setId(null);
        return clienteRepository.save(cliente);
    }

    public Cliente updateCliente(Cliente cliente){
        Cliente clientetoUpdate = find(cliente.getId());
        updateData(clientetoUpdate, cliente);
        return clienteRepository.save(clientetoUpdate);
    }

    public void updateData(Cliente clientetoUpdate, Cliente cliente){
        clientetoUpdate.setNome(cliente.getNome());
        clientetoUpdate.setEmail(cliente.getEmail());
        clientetoUpdate.setTelefone(cliente.getTelefone());
    }

    public Cliente find(Integer id){
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElseThrow(() -> new ObjectNotFoundException("Cliente não Encontrado" + id + ", do tipo: "
                +Cliente.class.getName()));
    }


    public Cliente fromDto(ClienteDto clienteDto) {
        return new Cliente(clienteDto.getId(), clienteDto.getNome(), clienteDto.getEmail(), clienteDto.getTelefone(),
                null, null);
    }

    public void deleteCliente(Integer id){
        find(id);
        try{
            clienteRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("Não é possível excluir um cliente com dados vinculados.");
        }
    }

    public List<Cliente> findAll(){return clienteRepository.findAll();}
}
