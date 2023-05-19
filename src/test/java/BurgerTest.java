import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger = new Burger();
    @Mock
    Bun bun;

    @Mock
    Ingredient ingredientOne;

    @Mock
    Ingredient ingredientTwo;

    @Before
    public void setUp() {
        when(bun.getPrice()).thenReturn(200F);
        when(ingredientOne.getPrice()).thenReturn(100F);
        when(ingredientTwo.getPrice()).thenReturn(300F);
        when(bun.getName()).thenReturn("Краторная булка");
        when(ingredientOne.getName()).thenReturn("cutlet");
        when(ingredientTwo.getName()).thenReturn("sour cream");
        when(ingredientOne.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientTwo.getType()).thenReturn(IngredientType.SAUCE);
    }

    @Test
    public void setBunTest() {
        burger.setBuns(bun);
        Assert.assertEquals("Неверный результат", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        burger.addIngredient(ingredientOne);
        Assert.assertEquals("Неверный результат", ingredientOne, burger.ingredients.get(0));
        Assert.assertEquals("Неверный результат", 1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        burger.addIngredient(ingredientOne);
        burger.removeIngredient(0);
        Assert.assertEquals("Неверный результат", 0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        burger.moveIngredient(1, 0);
        Assert.assertEquals("Неверный результат", ingredientTwo, burger.ingredients.get(0));
        Assert.assertEquals("Неверный результат", ingredientOne, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        float actual = burger.getPrice();
        float expected = 800F;
        Assert.assertEquals("Неверный результат", expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.addIngredient(ingredientOne);
        burger.addIngredient(ingredientTwo);
        String actual = burger.getReceipt();
        String expected = String.format("(==== Краторная булка ====)%n" +
                "= filling cutlet =%n" +
                "= sauce sour cream =%n" +
                "(==== Краторная булка ====)%n" +
                "%n" +
                "Price: 800,000000%n");
        Assert.assertEquals("Неверный результат", expected, actual);
    }
}