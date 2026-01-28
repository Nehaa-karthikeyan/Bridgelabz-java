package javacollectionsandstreams.javagenerics;
interface MealPlan {
    void prepare();
}

class VeganMeal implements MealPlan {
    public void prepare() {
        System.out.println("Preparing Vegan Meal");
    }
}

class Meal<T extends MealPlan> {
    static <T extends MealPlan> void generateMeal(T meal) {
        meal.prepare();
    }
}

public class MealPlanGenerator {
    public static void main(String[] args) {
        Meal.generateMeal(new VeganMeal());
    }
}
