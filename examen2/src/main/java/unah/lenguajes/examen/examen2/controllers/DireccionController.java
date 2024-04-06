package unah.lenguajes.examen.examen2.controllers;

import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.examen.examen2.entities.Cliente;
import unah.lenguajes.examen.examen2.entities.Direccion;
import unah.lenguajes.examen.examen2.services.DireccionService;
import unah.lenguajes.examen.examen2.services.impl.ClienteServiceImpl;
import unah.lenguajes.examen.examen2.services.impl.CuentasServiceImpl;
import unah.lenguajes.examen.examen2.services.impl.DireccionServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/direccion")
public class DireccionController {
    @Autowired
    DireccionServiceImpl direccionServiceImpl;

    @PostMapping("/crear/{dni}")
    public Direccion crearDireccion(@RequestBody Direccion direccion, @PathVariable String dni) {
        return this.direccionServiceImpl.crearDireccion(direccion, dni);
    }

}
