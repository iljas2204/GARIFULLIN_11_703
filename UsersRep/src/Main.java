import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User(scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
        User user1 = new User(scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
        User user2 = new User(scanner.nextLine(),scanner.nextLine(),scanner.nextLine(),scanner.nextLine());
        UsersRepositoryObjectsImpl usersRepositoryObjects = new UsersRepositoryObjectsImpl();
        usersRepositoryObjects.save(user);
        usersRepositoryObjects.save(user1);
        usersRepositoryObjects.save(user2);
        System.out.println(usersRepositoryObjects.findAll());
    }
}
