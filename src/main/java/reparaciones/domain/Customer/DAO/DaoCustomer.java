package reparaciones.domain.Customer.DAO;


import reparaciones.domain.Customer.Model.Customer;

import java.util.ArrayList;

public interface DaoCustomer {
    public void insertUser(Customer customer);

    public Customer loadUser(String username, String password);

    public Customer loadUser(int userId);

    public ArrayList<Customer> loadUsers();

    public void updateUser(Customer customer);

    public boolean deleteUser(int userId);
}
