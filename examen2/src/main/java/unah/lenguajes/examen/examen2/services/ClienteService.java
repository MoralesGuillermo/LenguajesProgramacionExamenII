package unah.lenguajes.examen.examen2.services;

import java.util.List;

import unah.lenguajes.examen.examen2.entities.Cliente;

public interface ClienteService {

    public Cliente crearCliente(Cliente cliente);

    public List<Cliente> obtenerClientes();

    public Cliente obtenerClientePorDni(String dni);

    

}
