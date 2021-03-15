package pizza.dao;

import java.util.List;

import pizza.pojo.Customer;

public interface CustomerDao 
{
    public boolean addCustomer(Customer customer);
    public boolean login(String name,String passord);
    public boolean updateCustomer(Customer customer);
    public boolean deleteCustomer(int id);
    public Customer getCustomer(String username);
    public List<Customer> getAllCustomer();
    public boolean forgotPassword(String username,String phoneNumber,String password);
    public boolean changePassword(String username,String newPassword);
}
