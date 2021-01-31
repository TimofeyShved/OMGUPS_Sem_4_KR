import org.junit.Test;
import static org.junit.Assert.*;

public class BigNumTest {
    @Test
    public void shift() throws Exception {
        BigNum x = new BigNum(6);
        x.shift(1);
        assertEquals(x.toString(), "600");
    }

    @Test
    public void isLarger() throws Exception {
        BigNum x = new BigNum(6);
        BigNum y = new BigNum(5);
        assertEquals(x.isLarger(y), true);
        assertEquals(y.isLarger(x), false);
    }

    @Test
    public void mul() throws Exception {
        BigNum x = new BigNum(6);
        BigNum y = new BigNum(115);
        x.mul(y);
        assertEquals(x.toString(), "690");
    }

    @Test
    public void sub() throws Exception {
        BigNum x = new BigNum(7);
        BigNum y = new BigNum(5);
        x.sub(y);
        assertEquals(x.toString(), "2");
        y.sub(new BigNum(1));
        assertEquals(y.toString(), "4");
    }

    @Test
    public void add() throws Exception {
        BigNum x = new BigNum(55);
        x.add(x);
        assertEquals(x.toString(), "110");
        x.add(new BigNum(9999));
        assertEquals(x.toString(), "10109");
    }

    @Test
    public void division() throws Exception {
        BigNum x = new BigNum(1010);
        BigNum y = new BigNum(101);
        x.division(y);
        assertEquals(x.toString(), "10");
        x = new BigNum(921);
        y = new BigNum(3);
        x.division(y);
        assertEquals(x.toString(), "307");
        x = new BigNum(174000);
        y = new BigNum(300);
        x.division(y);
        assertEquals(x.toString(), "580");
        x = new BigNum(2);
        y = new BigNum(300);
        x.division(y);
        assertEquals(x.toString(), "0");
    }

    @Test
    public void toStringTest() throws Exception {
        assertEquals(new BigNum(10).toString(), "10");
        assertEquals(new BigNum(9999).toString(), "9999");
        assertEquals(new BigNum(10203).toString(), "10203");
        BigNum x = new BigNum(1);
        long y = Integer.parseInt(x.toString());
        assertEquals(y, 1);
    }

}
