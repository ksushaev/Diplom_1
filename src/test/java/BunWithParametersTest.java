import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;


@RunWith(Parameterized.class)
public class BunWithParametersTest {
    private String name;
    private float price;


    public BunWithParametersTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters()
    public static Object[][] bunsWithPar() {
        return new Object[][]{
                {"Краторная булка", 120},
                {null, 0.00001F},
                {"", 100F},
                {"Булка", 0},
                {"Очень большое название булочка, вдруг кто-то захочет назвать особенно", -9383},
                {"%:,%,.№", 99999999999999F}

        };
    }

    @Test
    public void setNameOfBun() {
        Bun bun = new Bun(name, price);
        String expected = name;
        Assert.assertEquals(expected, bun.getName());
    }

    @Test
    public void setBunPrice() {
        Bun bun = new Bun(name, price);
        float expected = price;
        Assert.assertEquals(expected, bun.getPrice(), 0);
    }
}
