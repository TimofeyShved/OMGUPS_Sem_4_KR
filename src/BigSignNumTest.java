import org.junit.Test;
import static org.junit.Assert.*;

public class BigSignNumTest {
    @Test
    public void mul() throws Exception {
        BigSignNum x = new BigSignNum(-6);
        BigSignNum y = new BigSignNum(115);
        x.mul(y);
        assertEquals(x.toString(), "-690");
        x.mul(new BigSignNum(-333));
        assertEquals(x.toString(), "229770");
    }

    @Test
    public void sub() throws Exception {
        BigSignNum x = new BigSignNum(7);
        BigSignNum y = new BigSignNum(5);
        x.sub(y);
        assertEquals(x.toString(), "2");
        x = new BigSignNum(7);
        y = new BigSignNum(5);
        y.sub(x);
        assertEquals(y.toString(), "-2");
        x = new BigSignNum(3);
        y = new BigSignNum(-4);
        x.sub(y);
        assertEquals(x.toString(), "7");
    }


    @Test
    public void add() throws Exception {
        BigSignNum x = new BigSignNum(2);
        x.add(new BigSignNum(2));
        assertEquals(x.toString(),"4");
        x.add(new BigSignNum(-8));
        assertEquals(x.toString(),"-4");
        x.add(new BigSignNum(2));
        assertEquals(x.toString(),"-2");
        x.add(new BigSignNum(-8));
        assertEquals(x.toString(),"-10");
    }

    @Test
    public void division() throws Exception {
        BigSignNum x = new BigSignNum(1010);
        BigSignNum y = new BigSignNum(101);
        x.division(y);
        assertEquals(x.toString(), "10");
        x = new BigSignNum(-921);
        y = new BigSignNum(3);
        x.division(y);
        assertEquals(x.toString(), "-307");
        x = new BigSignNum(-174000);
        y = new BigSignNum(-300);
        x.division(y);
        assertEquals(x.toString(), "580");
        x = new BigSignNum(2);
        y = new BigSignNum(-300);
        x.division(y);
        assertEquals(x.toString(), "-0");
    }

    @Test
    public void toStringTest() throws Exception {
        assertEquals(new BigSignNum(10).toString(), "10");
        assertEquals(new BigSignNum(-9999).toString(), "-9999");
        assertEquals(new BigSignNum(-10203).toString(), "-10203");
        BigSignNum x = new BigSignNum(-11);
        long y = Integer.parseInt(x.toString());
        assertEquals(y, -11);
    }

}
