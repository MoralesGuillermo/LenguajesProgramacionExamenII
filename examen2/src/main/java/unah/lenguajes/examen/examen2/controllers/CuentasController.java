package unah.lenguajes.examen.examen2.controllers;

import org.springframework.web.bind.annotation.RestController;

import unah.lenguajes.examen.examen2.entities.Cliente;
import unah.lenguajes.examen.examen2.entities.Cuentas;
import unah.lenguajes.examen.examen2.services.impl.ClienteServiceImpl;
import unah.lenguajes.examen.examen2.services.impl.CuentasServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/cuentas")
public class CuentasController {
    @Autowired
    CuentasServiceImpl cuentasServiceImpl;

    @PostMapping("/crear")
    public Cuentas crearCuenta(@RequestBody Cuentas cuenta) {
        return this.cuentasServiceImpl.crearCuenta(cuenta);
    }

    @PostMapping("/asociar/{dni}")
    public String asociarCuentaCliente(@PathVariable String dni, @RequestParam String numeroCuenta) {
        return this.cuentasServiceImpl.asociarCuentaACliente(dni, numeroCuenta);
    }

    @GetMapping("/get/movimientos")
    public Cuentas obtenerMovimientosCuenta(@RequestParam String numeroCuenta) {
        return this.cuentasServiceImpl.obtenerMovimientosPorCuenta(numeroCuenta);
    }
}
