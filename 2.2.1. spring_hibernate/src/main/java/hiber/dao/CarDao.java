package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.springframework.stereotype.Service;

import javax.persistence.Query;
import java.util.List;

@Service
public interface CarDao {

    void add(Car car);

    List<Car> listCars();


}
