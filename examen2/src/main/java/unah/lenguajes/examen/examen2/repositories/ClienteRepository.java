package unah.lenguajes.examen.examen2.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import unah.lenguajes.examen.examen2.entities.Cliente;


@Repository
public interface ClienteRepository extends CrudRepository<Cliente, String> {

}
