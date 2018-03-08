package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.model.MealWithExceed;

import java.util.List;

public interface MealDAO {
    List<MealWithExceed> getAll();
    MealWithExceed getEntityById(int id);
    Meal update(Meal meal);
    boolean delete(int id);
    boolean create(Meal meal);
}
