import java.util.List;

public interface UsersRepository {
    void save(User user);
    void deleteByLogin(String login);
    User findByLogin(String login);
    List<User> findAll();
}
