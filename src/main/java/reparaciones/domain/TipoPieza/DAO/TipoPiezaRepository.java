package reparaciones.domain.TipoPieza.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reparaciones.domain.TipoPieza.Model.TipoPieza;

@Repository
public interface TipoPiezaRepository extends JpaRepository<TipoPieza, Integer> { //integer por el id

}
