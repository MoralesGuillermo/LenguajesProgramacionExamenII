package unah.lenguajes.examen.examen2.services;

import java.util.List;

import unah.lenguajes.examen.examen2.dto.MovimientoDto;
import unah.lenguajes.examen.examen2.entities.Movimientos;

public interface MovimientoService {

    public Movimientos crearMovimiento(MovimientoDto movimientoDto);

}
