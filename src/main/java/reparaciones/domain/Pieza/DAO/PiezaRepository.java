package reparaciones.domain.Pieza.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reparaciones.domain.Pieza.Model.Pieza;

@Repository
public interface PiezaRepository extends JpaRepository<Pieza, Integer> { //integer por el id

}
