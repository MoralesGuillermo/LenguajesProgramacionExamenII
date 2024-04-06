package unah.lenguajes.examen.examen2.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Movimientos")
@Data
public class Movimientos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmovimiento")
    private int idMovimiento;

    @Column(name="tipomovimiento")
    private char tipoMovimiento;

    private double monto; 

    @Column(name="fechamovimiento")
    private LocalDate fechamMovimiento = LocalDate.now();

    @ManyToOne
    @JoinColumn(name="numerocuenta", referencedColumnName="numerocuenta")
    @JsonBackReference
    private Cuentas cuenta;
}
