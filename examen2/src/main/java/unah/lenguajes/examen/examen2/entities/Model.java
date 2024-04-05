package unah.lenguajes.examen.examen2.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="MODEL")
@Data
public class Model {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nombrecolumna")
    private String id;

    //@ManyToMany()
    //@JoinTable(name, joinColumns, inverseJoinColumns)
}
