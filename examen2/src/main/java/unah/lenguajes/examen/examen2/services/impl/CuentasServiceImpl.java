package unah.lenguajes.examen.examen2.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import unah.lenguajes.examen.examen2.entities.Cliente;
import unah.lenguajes.examen.examen2.entities.Cuentas;
import unah.lenguajes.examen.examen2.repositories.ClienteRepository;
import unah.lenguajes.examen.examen2.repositories.CuentasRepository;
import unah.lenguajes.examen.examen2.services.CuentaService;

public class CuentasServiceImpl implements CuentaService {

    @Autowired
    CuentasRepository cuentasRepository;
    
    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public Cuentas crearCuenta(Cuentas cuenta) {
        String numeroCuenta = cuenta.getNumeroCuenta();
        double saldo = cuenta.getSaldo();
        if (this.cuentasRepository.existsById(numeroCuenta) && saldo > 500){
            return this.cuentasRepository.save(cuenta);
        }
        return null;


    }

    @Override
    public String asociarCuentaACliente(String dni, String numeroCuenta) {
        if (this.clienteRepository.existsById(dni) && this.cuentasRepository.existsById(numeroCuenta)){
            Cuentas cuenta = this.cuentasRepository.findById(numeroCuenta).get();
            if (null == cuenta.getCliente()){
                Cliente cliente = this.clienteRepository.findById(dni).get();
                cliente.getCuentas().add(cuenta);
                cuenta.setCliente(cliente);
                this.clienteRepository.save(cliente);
                this.cuentasRepository.save(cuenta);
            }
            return String.format("La cuenta %s ya se encuentra asociada a un cliente", numeroCuenta);
        }
        return "El cliente o la cuenta a asociar no existen";
    }

}
