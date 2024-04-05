package unah.lenguajes.examen.examen2.entities;

import java.time.LocalDate;

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
    public char tipoMovimiento;

    public double monto; 

    @Column(name="fechamovimiento")
    public LocalDate fechamMovimiento;

    @ManyToOne
    @JoinColumn(name="numerocuenta", referencedColumnName="numerocuenta")
    public Cuentas cuenta;
}
