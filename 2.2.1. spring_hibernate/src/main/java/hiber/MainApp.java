package hiber;
import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;


public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      User user1 = userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      User user2 = userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      User user3 = userService.add(new User("User3", "Lastname3", "user3@mail.ru"));


      carService.add(new Car(user1,"BMW", 7));
      carService.add(new Car(user2,"Lada", 1));
      carService.add(new Car(user3, "Skoda", 4));

      System.out.println(userService.listUsers());
      System.out.println(carService.listCars());


      User getuser = carService.getOwner("BMW", 7);

      System.out.println(getuser);

      context.close();
   }
}
