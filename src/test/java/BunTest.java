import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bunForTest = new Bun("Краторная булка", 1255F);


    @Test
    public void getNameTest() {
        String expected = "Краторная булка";
        String actual = bunForTest.getName();
        Assert.assertEquals("Имя булки не совпадает", expected, actual);
    }

    @Test
    public void getPriceTest() {
        float expected = 1255F;
        float actual = bunForTest.getPrice();
        Assert.assertEquals("Цена булки не совпадает", expected, actual, 0);
    }
}
