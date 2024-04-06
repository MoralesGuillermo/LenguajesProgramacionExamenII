package unah.lenguajes.examen.examen2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.lenguajes.examen.examen2.dto.MovimientoDto;
import unah.lenguajes.examen.examen2.entities.Cuentas;
import unah.lenguajes.examen.examen2.entities.Movimientos;
import unah.lenguajes.examen.examen2.repositories.CuentasRepository;
import unah.lenguajes.examen.examen2.repositories.MovimientosRepository;
import unah.lenguajes.examen.examen2.services.MovimientoService;

@Service
public class MovimientosServiceImpl implements MovimientoService{

    @Autowired
    MovimientosRepository movimientosRepository;

    @Autowired
    CuentasRepository cuentasRepository;



    @Override
    public Movimientos crearMovimiento(MovimientoDto movimientoDto) {
        String numeroCuenta = movimientoDto.getNumeroCuenta();
        char tipoMovimiento = movimientoDto.getTipoMovimiento();
        double monto = movimientoDto.getMonto();

        if (this.cuentasRepository.existsById(numeroCuenta)){
            if (tipoMovimiento == 'C' || tipoMovimiento == 'D'){
                Cuentas cuenta = this.cuentasRepository.findById(numeroCuenta).get();
                double saldoCuenta = cuenta.getSaldo();
                switch (tipoMovimiento) {
                    case 'C':
                        double saldoCredito = saldoCuenta + monto;
                        cuenta.setSaldo(saldoCredito);
                        break;
                    case 'D':
                        double saldoDebito = saldoCuenta - monto;
                        if (saldoDebito < 0 && !cuenta.getSobregiro()){
                            return null;
                        }
                        cuenta.setSaldo(saldoDebito);
                        break;
                    default:
                        break;
                }
                Cuentas savedCuenta = this.cuentasRepository.save(cuenta);
                Movimientos movimiento = new Movimientos();
                movimiento.setCuenta(savedCuenta);
                movimiento.setMonto(monto);
                movimiento.setTipoMovimiento(tipoMovimiento);
                return this.movimientosRepository.save(movimiento);
            }
            return null;
        }
        return null;
    }
}
