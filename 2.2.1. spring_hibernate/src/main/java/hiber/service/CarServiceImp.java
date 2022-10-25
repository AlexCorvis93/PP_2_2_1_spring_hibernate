package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarServiceImp implements CarService{
    private CarDao carDao;

    @Autowired
    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public Car add(Car car) {
        carDao.add(car);
        return car;
    }

    @Transactional
    @Override
    public List<Car> listCars() {
        return carDao.listCars();
    }

    @Transactional
    @Override
    public User getOwner(String model, int series) {
        return carDao.getOwner(model, series);
    }
}
