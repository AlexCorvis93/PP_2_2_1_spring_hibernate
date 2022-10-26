package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

   Car getCar(String name);


   void setCar(Car car);

   User getOwner(String model, int series);

}
