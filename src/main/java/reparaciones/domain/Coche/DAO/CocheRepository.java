package reparaciones.domain.Coche.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import reparaciones.domain.Coche.Model.Coche;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> { //integer por el id

}
