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

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");

      Car car1 = new Car("BMW", 7);
      Car car2 = new Car("Lada", 1);
      Car car3 = new Car("Skoda", 4);

      user1.setCar(car1);
      user2.setCar(car2);
      user3.setCar(car3);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);



      User getuser = carService.getOwner("Lada", 1);


      System.out.println(getuser);

      Car usercar = userService.getCar("User3");
      System.out.println(usercar);


      context.close();
   }
}
