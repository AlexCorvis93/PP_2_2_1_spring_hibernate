package hiber.model;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;

import javax.persistence.*;

@Entity
@Table(name = "Car")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "users_id", referencedColumnName = "id", unique = true)
    private User user;

    @Column
    private String model;

    @Column
    private int series;


    public Car() {};

    public Car(User user, String model, int series) {
        this.user = user;
        this.model = model;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) { this.model = model; }

    public int getSeries() { return series; }

    public void setSeries(int series) { this.series = series; }

    @Override
    public String toString() {
        return "model : " + getModel() +
                "series : " + getSeries();
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



}
