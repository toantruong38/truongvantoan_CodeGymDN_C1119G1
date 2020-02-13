package userdao;

import model.Login;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao
{
    private static List<User> users;

    static
    {
        users = new ArrayList<>();

        users.add(new User("admin", "admin", "admin", "admin@host", 24));
        users.add(new User("guest1", "guest1", "guest1", "guest1@host", 24));
        users.add(new User("guest2", "guest2", "guest2", "guest2@host", 24));
        users.add(new User("guest3", "guest3", "guest3", "guest3@host", 24));
        users.add(new User("guest4", "guest4", "guest4", "guest4@host", 24));
        users.add(new User("guest5", "guest5", "guest5", "guest5@host", 24));
    }

    public static User checkLogin(Login login)
    {
        for (User u : users)
        {
            if (u.getUser().equals(login.getUser()) &&
                    u.getPass().equals(login.getPass()))
            {
                return u;
            }
        }

        return null;
    }
}
