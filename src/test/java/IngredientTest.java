import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {
    private final String name = "Соус традиционный галактический";
    private final float price = 15F;

    Ingredient ingredient = new Ingredient(IngredientType.SAUCE, name, price);


    @Test
    public void getName() {
        Assert.assertEquals("Неверный результат", name, ingredient.getName());
    }

    @Test
    public void getPrice() {
        Assert.assertEquals("Неверный результат", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getType() {
        Assert.assertEquals("Результат не совпал с ожидаемым", IngredientType.SAUCE, ingredient.getType());
    }
}