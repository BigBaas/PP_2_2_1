package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean((CarService.class));

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", new Car("model1",200)));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", new Car("model2",300)));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", new Car("model3",400)));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", new Car("model4",500)));

      List<User> user = userService.listUsers();
      List<Car> car = carService.listCars();

      System.out.println(user.toString());
      System.out.println(car.toString());
      System.out.println(userService.retUserByCar("model1", 200));

      context.close();
   }
}
