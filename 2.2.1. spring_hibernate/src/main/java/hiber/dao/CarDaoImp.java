package hiber.dao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImp implements CarDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(Car car) {
        sessionFactory.getCurrentSession().save(car);
    }

    @Override
    public List<Car> listCars() {
        TypedQuery<Car> cars = sessionFactory.getCurrentSession().createQuery("from Car");
        return cars.getResultList();
    }

    @Override
    public User getOwner(String model, int series) {
        User user = new User();
        for (Car car : listCars()) {
            if (car.getModel().equals(model) && car.getSeries() == series) {
                long id = car.getId();
                Query query = sessionFactory.getCurrentSession().createQuery("from User where id = :paramId");
                query.setParameter("paramId", id);
                user = (User) query.getSingleResult();
            }
        }
        return user;

    }


}
