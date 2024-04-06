package unah.lenguajes.examen.examen2.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.examen.examen2.entities.Cliente;
import unah.lenguajes.examen.examen2.entities.Direccion;
import unah.lenguajes.examen.examen2.repositories.ClienteRepository;
import unah.lenguajes.examen.examen2.repositories.DireccionRepository;
import unah.lenguajes.examen.examen2.services.DireccionService;

@Service
public class DireccionServiceImpl implements DireccionService{

    @Autowired
    DireccionRepository direccionRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Direccion crearDireccion(Direccion direccion, String clienteDni) {
        if (this.clienteRepository.existsById(clienteDni)){
            Cliente cliente = this.clienteRepository.findById(clienteDni).get();
            direccion.setCliente(cliente);
            return this.direccionRepository.save(direccion);
        }
        return null;
    }

}
