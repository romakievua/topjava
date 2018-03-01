package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExceed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;

/**
 * GKislin
 * 31.05.2015.
 */
public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> mealList = Arrays.asList(
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,10,0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,13,0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 30,20,0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,10,0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,13,0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2015, Month.MAY, 31,20,0), "Ужин", 510)
        );
        List<UserMealWithExceed> userMealWithExceeds = getFilteredWithExceeded(mealList, LocalTime.of(7, 0), LocalTime.of(12,0), 2000);
//        .toLocalDate();
//        .toLocalTime();

        for (UserMealWithExceed userMealWithExceed : userMealWithExceeds) {
            System.out.println(userMealWithExceed);
        }
    }

    public static List<UserMealWithExceed>  getFilteredWithExceeded(List<UserMeal> mealList, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        List<UserMealWithExceed> result = new ArrayList<>();
        Map<LocalDate, Integer> map = new HashMap<>();
        for (UserMeal userMeal : mealList) {
            LocalDate date = userMeal.getDateTime().toLocalDate();
            int calories = userMeal.getCalories();
            if (map.containsKey(date))
                calories += map.get(date);

            map.put(date, calories);
        }

        for (UserMeal userMeal : mealList) {
            LocalDateTime userMealDateTime = userMeal.getDateTime();
            LocalDate userMealDate = userMeal.getDateTime().toLocalDate();
            LocalTime userMealTime = userMeal.getDateTime().toLocalTime();
            int userMealCalories = userMeal.getCalories();
            boolean isExceed = false;

            if (TimeUtil.isBetween(userMealTime, startTime, endTime)) {
                if (map.containsKey(userMealDate) && map.get(userMealDate) > caloriesPerDay)
                    isExceed = true;
                result.add(new UserMealWithExceed(userMealDateTime, userMeal.getDescription(), userMealCalories, isExceed));
            }
        }
        /*for (Map.Entry<LocalDate, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }*/
        return result;
    }
}
