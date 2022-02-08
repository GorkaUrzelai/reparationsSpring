package reparaciones.domain.Coche.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import reparaciones.domain.Coche.Model.Coche;

import java.util.List;

@Repository
public interface CocheRepository extends JpaRepository<Coche, Integer> {


   /*@Query("select c from Coche c where c.dueño.id=?1")*/
    @Query("select co from Coche co join Customer cu on cu.id = co.dueño where cu.id=?1")
    List<Coche> getCoches(int customerId);

    @Transactional
    @Modifying
    @Query("update Coche c set c.kilometros=?2 where c.cocheID =?1")
    void editCocheKilometros(Integer c, Integer kilometros);
}
