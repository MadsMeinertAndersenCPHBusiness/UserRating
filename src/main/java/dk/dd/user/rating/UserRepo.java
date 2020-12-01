package dk.dd.user.rating;

public interface UserRepo {
    User create(User user);
    boolean update(User user);
    boolean delete(String id);
    User get(String name);

}
