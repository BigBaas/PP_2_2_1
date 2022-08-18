package hiber.service;

import hiber.model.User;

import java.util.List;

public interface UserService {
    CarService add(User user);
    List<User> listUsers();
    User retUserByCar(String model, int series);
}
