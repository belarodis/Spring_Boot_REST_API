package com.belarodis.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static Integer usersCount = 0;

    static {
        users.add(new User(++usersCount, "Bela", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Lafa", LocalDate.now().minusYears(30)));
        users.add(new User(++usersCount, "Marcela", LocalDate.now().minusYears(30)));
    }

    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }
    
    public User save(User user) {
        user.setId(++usersCount);

        users.add(user);
        return user;
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
