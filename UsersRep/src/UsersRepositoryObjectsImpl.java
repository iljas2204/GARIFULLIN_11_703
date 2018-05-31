import java.util.ArrayList;
import java.util.List;

public class UsersRepositoryObjectsImpl implements UsersRepository {

    List<User> list = new ArrayList<>();

    @Override
    public void save(User user) {
        list.add(user);
    }

    @Override
    public void deleteByLogin(String login) {
        for (int i = 0; i < list.size(); i++) {
            if(login.equals(list.get(i).getLogin())){
                list.remove(i);
                break;
            }
        }
    }

    @Override
    public User findByLogin(String login) {
        for (int i = 0; i < list.size() ; i++) {
            if(login.equals(list.get(i).getLogin())){
                return list.get(i);
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return list.subList(0,list.size());
    }
}
