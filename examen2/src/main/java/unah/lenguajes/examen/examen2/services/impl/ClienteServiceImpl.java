package unah.lenguajes.examen.examen2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.examen.examen2.entities.Cliente;
import unah.lenguajes.examen.examen2.repositories.ClienteRepository;
import unah.lenguajes.examen.examen2.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        if (this.clienteRepository.existsById(cliente.getDni())){
            return null;
        }
        return this.clienteRepository.save(cliente);
    }

    @Override
    public List<Cliente> obtenerClientes() {
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    @Override
    public Cliente obtenerClientePorDni(String dni) {
        // TODO Finish the method to get all its movimientos
        return this.clienteRepository.findById(dni).get();
    }


}
