package test;

import model.FoodItem;
import model.Fridge;
import model.RegularRecipe;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestFridge {
    Fridge fridge;
    FoodItem f1;
    FoodItem f2;
    FoodItem f3;

    @BeforeEach
    public void setup() {
        fridge = new Fridge();
        f1 = new FoodItem("carrot");
        f2 = new FoodItem("strawberries");
        f3 = new FoodItem("beef");
        f1.addContainedIn(new RegularRecipe("curry chicken"));
        f2.addContainedIn(new RegularRecipe("strawberry cheesecake"));
        f3.addContainedIn(new RegularRecipe("beef udon"));
    }

    @Test
    public void testAddToIngredientList() {
        assertTrue(fridge.getIngredients().isEmpty());

        // when fridge doesn't contain the food item
        fridge.addToIngredientList(f1);
        assertTrue(fridge.getIngredients().contains(f1));
        fridge.addToIngredientList(f2);
        assertTrue(fridge.getIngredients().size() == 2);
        assertTrue(fridge.getIngredients().contains(f2));
        assertFalse(fridge.getIngredients().contains(f3));
        fridge.addToIngredientList(f3);
        assertTrue(fridge.getIngredients().contains(f3));
        assertTrue(fridge.getIngredients().size() == 3);

        // when fridge contains the food item, it should move the recipe
        // in ContainedIn of the food item to the ContainedIn of the food item in fridge
        assertTrue(fridge.getIngredients().get(0).getContainedIn().size() == 1);
        assertTrue(fridge.getIngredients().get(0).getContainedIn().contains("curry chicken"));
        FoodItem f4 = new FoodItem("carrot");
        f4.addContainedIn(new RegularRecipe("carrot cake"));
        fridge.addToIngredientList(f4);
        assertTrue(fridge.getIngredients().size() == 3);
        assertTrue(fridge.getIngredients().contains(f4));
        assertTrue(fridge.getIngredients().get(0).getContainedIn().size() == 2);
        assertTrue(fridge.getIngredients().get(0).getContainedIn().contains("carrot cake"));
    }

    @Test
    public void testAddToFridge() {
        assertTrue(fridge.getFridge().isEmpty());
    }

    @Test
    public void testRemoveFromFrdige() {

    }

    @Test
    public void testSave() {

    }

    @Test
    public void testLoad() {

    }
}
