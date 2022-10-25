package hiber.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GenerationType;
import javax.persistence.Column;


@Entity
@Table(name = "Car")
public class Car {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String model;

    @Column
    private int series;


    public Car() {};

    public Car( String model, int series) {
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
                "  series : " + getSeries();
    }


}
