package unah.lenguajes.examen.examen2.controllers;

import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.examen.examen2.dto.MovimientoDto;
import unah.lenguajes.examen.examen2.entities.Movimientos;
import unah.lenguajes.examen.examen2.services.impl.MovimientosServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/movimientos")
public class MovimientosController {
    @Autowired
    MovimientosServiceImpl movimientosServiceImpl;

    @PostMapping("/crear")
    public Movimientos crearMovimiento(@RequestBody MovimientoDto movimientoDto) {
        return this.movimientosServiceImpl.crearMovimiento(movimientoDto);
    }
}
