package unah.lenguajes.examen.examen2.controllers;

import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.examen.examen2.entities.Cliente;
import unah.lenguajes.examen.examen2.services.impl.ClienteServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    @Autowired
    ClienteServiceImpl clienteServiceImpl;
    
    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente cliente) {
        return this.clienteServiceImpl.crearCliente(cliente);
    }

    @GetMapping("/all")
    public List<Cliente> obtenerClientes() {
        return this.clienteServiceImpl.obtenerClientes();
    }

    @GetMapping("/get/{dni}")
    public Cliente obtenerClientePorDni(@PathVariable String dni) {
        return this.clienteServiceImpl.obtenerClientePorDni(dni);
    }
}
