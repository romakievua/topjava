package ru.javawebinar.topjava;

import ru.javawebinar.topjava.dao.MealDAO;
import ru.javawebinar.topjava.dao.MealDAOImpl;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import java.time.LocalDateTime;
import java.time.Month;

/**
 * @see <a href="http://topjava.herokuapp.com">Demo</a>
 * @see <a href="https://github.com/JavaOPs/topjava">Initial project</a>
 */
public class Main {
    public static void main(String[] args) {
        System.out.format("Hello Topjava Enterprise!");
        System.out.println();
        MealDAO dao = new MealDAOImpl();
        dao.getAll().forEach((meal) -> System.out.println(meal));
        System.out.println("======================================================");
        System.out.println(dao.getEntityById(5));
        System.out.println("======================================================");
        System.out.println(dao.delete(5));
        dao.getAll().forEach((meal) -> System.out.println(meal));
        System.out.println("======================================================");
        dao.update(new Meal(2, LocalDateTime.of(2015, Month.MAY, 29, 20, 0), "Ужин", 510));
        dao.getAll().forEach((meal) -> System.out.println(meal));
        System.out.println("======================================================");
        dao.create(new Meal(LocalDateTime.of(2015, Month.MAY, 31, 23, 59), "Ужин", 510));
        dao.getAll().forEach((meal) -> System.out.println(meal));
    }
}
