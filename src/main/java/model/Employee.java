package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Employee(String first_name, String last_name, String gender, int age,City city ) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public Employee() {

    }
    public Employee(int id,String firstName,String lastName,String gender,int age,City city ) {
        this.id = id;
        this.first_name = firstName;
        this.last_name = lastName;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if (o == null||getClass()!=o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && Objects.equals(first_name, employee.first_name)&& Objects.equals(last_name, employee.last_name) && Objects.equals(gender, employee.gender) && Objects.equals(age, employee.age) && Objects.equals(city, employee.city);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, gender, age, city);
    }
    @Override
    public String toString() {
        return "id: " + id + ", First name: " + first_name +
                ", Last name: " + last_name + ", Gender: " + gender +
                ", Age: " + age + ", City name: " + city;
    }
}
