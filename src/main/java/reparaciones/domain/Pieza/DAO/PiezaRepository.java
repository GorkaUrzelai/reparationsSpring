package reparaciones.domain.Pieza.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reparaciones.domain.Pieza.Model.Pieza;
import reparaciones.domain.TipoPieza.Model.TipoPieza;

import java.util.Set;

@Repository
public interface PiezaRepository extends JpaRepository<Pieza, Integer> { //integer por el id

    @Query("select p from TipoPieza p")
    Set<TipoPieza> getTiposPiezas();
}
