package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MealDAOImpl implements MealDAO {
    private List<Meal> meals;

    public MealDAOImpl() {
        List<Meal> meals = Arrays.asList(
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 10, 0), "Завтрак", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 13, 0), "Обед", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 30, 20, 0), "Ужин", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 10, 0), "Завтрак", 1000),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 13, 0), "Обед", 500),
                new Meal(LocalDateTime.of(2015, Month.MAY, 31, 20, 0), "Ужин", 510)
        );
        this.meals = new ArrayList<>(meals);
    }

    @Override
    public List<MealWithExceed> getAll() {
        return MealsUtil.getMealWithExceeded(meals, 2000);
    }

    @Override
    public MealWithExceed getEntityById(int id) {
        for (MealWithExceed mealWithExceed : getAll()) {
            if (mealWithExceed.getId() == id)
                return mealWithExceed;
        }
        return null;
    }

    @Override
    public Meal update(Meal meal) {
        int id = 0;
        for (Meal mealFromList : meals) {
            if (mealFromList.getId() == meal.getId()) {
                id = meal.getId();
            }
        }
        if (id != 0) {
            delete(id);
            create(meal);
            return meal;
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        for (Meal meal : meals) {
            if (meal.getId() == id) {
                meals.remove(meal);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean create(Meal meal) {
        return meals.add(meal);
    }
}
