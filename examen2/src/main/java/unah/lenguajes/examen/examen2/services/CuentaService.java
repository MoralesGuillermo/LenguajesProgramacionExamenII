package unah.lenguajes.examen.examen2.services;

import unah.lenguajes.examen.examen2.entities.Cuentas;

public interface CuentaService {

    public Cuentas crearCuenta(Cuentas cuenta);

    public String asociarCuentaACliente(String clienteDni, String numeroCuenta);

}
