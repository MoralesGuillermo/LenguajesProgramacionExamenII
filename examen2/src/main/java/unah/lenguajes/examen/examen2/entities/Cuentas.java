package unah.lenguajes.examen.examen2.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Cuentas")
@Data
public class Cuentas {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numerocuenta")
    private String numeroCuenta;

    public double saldo;

    @Column(name="fechaapertura")
    public LocalDate fechaApertura = LocalDate.now(); 

    public boolean estado = true;

    public boolean sobregiro;

    @ManyToOne
    @JoinColumn(name="dni", referencedColumnName="dni")
    @JsonBackReference
    public Cliente cliente;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    public List<Movimientos> movimientos;
}
