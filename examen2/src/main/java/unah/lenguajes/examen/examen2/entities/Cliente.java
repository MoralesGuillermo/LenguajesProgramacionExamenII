package unah.lenguajes.examen.examen2.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    public String nombre;

    public String apellido; 

    public String correo;

    public String telefono;

    @OneToOne(mappedBy = "cliente")
    public Direccion direccion;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonManagedReference
    public List<Cuentas> cuentas;

}
