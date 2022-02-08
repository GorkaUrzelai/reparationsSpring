package reparaciones.domain.Customer.DAO;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import reparaciones.domain.Customer.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> { //integer por el id

    Customer findCustomerById(Integer id);

    public Optional<Customer> findByUsername(String username);

    List<Customer> findByEmail(String email);

    public Optional<Customer> findByFirstName(String firstName);

    @Transactional
    @Modifying
    @Query("update Customer u set u.username=?2, u.email=?3 where u.id =?1")
    void editCustomer(int idCustomer, String username, String email);

    @Query("select cu.cochePreferido from Customer cu where cu.id=?1")
    Integer findCochePreferido(Integer customerID);
}
