import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
    private final IngredientType typeOfIng;


    public IngredientTypeTest(IngredientType typeOfIng) {
        this.typeOfIng = typeOfIng;
    }


    @Parameterized.Parameters()
    public static Object[][] getIng() {
        return new Object[][]{
                {SAUCE},
                {FILLING},
        };
    }

    @Test
    public void ingTypeTest() {
        Assert.assertEquals("Неверный результат", typeOfIng, IngredientType.valueOf(String.valueOf(typeOfIng)));
    }
}
