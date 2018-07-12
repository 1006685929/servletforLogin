package dao;

public interface UserDao {
    public User login(String username,String password);
    public boolean addUser(User user);
    public boolean isExist(String username);

}
