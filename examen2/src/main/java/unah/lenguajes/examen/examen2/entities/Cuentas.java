package unah.lenguajes.examen.examen2.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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

    private double saldo;

    @Column(name="fechaapertura")
    private LocalDate fechaApertura = LocalDate.now(); 

    private boolean estado = true;

    private boolean sobregiro;

    @ManyToOne
    @JoinColumn(name="dni", referencedColumnName="dni")
    @JsonBackReference
    private Cliente cliente;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Movimientos> movimientos;

    public boolean getSobregiro(){
        return this.sobregiro;
    }
}
