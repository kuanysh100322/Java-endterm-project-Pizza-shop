package pizza.dao;

import pizza.pojo.Admin;

public interface AdminDao
{
	public boolean addAdmin(Admin customer);
    public boolean login(String name,String passord);
    public boolean updateAdmin(Admin admin);
    public boolean deleteAdmin(int id);
    public Admin getAdmin(String username);
    public boolean forgotPassword(String username,String phoneNumber,String password);
    public boolean changePassword(String username,String newPassword);
}
