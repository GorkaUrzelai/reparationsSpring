package reparaciones.domain.Customer.DAO;

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
}
