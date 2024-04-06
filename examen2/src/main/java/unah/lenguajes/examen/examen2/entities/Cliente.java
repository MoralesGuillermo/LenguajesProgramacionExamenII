package unah.lenguajes.examen.examen2.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Cliente")
@Data
public class Cliente {

    @Id
    @Column(name="dni")
    private String dni;

    private String nombre;

    private String apellido; 

    private String correo;

    private String telefono;

    @OneToOne(mappedBy = "cliente")
    private Direccion direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Cuentas> cuentas;
}
