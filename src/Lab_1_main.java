public class Lab_1_main {
    public static void main(String[] args){
        System.out.println("Hi");

        System.out.println("-------------------------------1-------------------------------");

        BigNum x = new BigNum(6);
        BigNum y = new BigNum(5);
        x.sub(y);
        System.out.println("x");
        for (int i=x.len-1; i>=0; i--)
        {
            System.out.print(x.digits[i]+" | ");
        }
        System.out.println("");
        for (int i=y.len-1; i>=0; i--)
        {
            System.out.print(y.digits[i]+" | ");
        }
        System.out.println("y");
        System.out.println("");

        x.mul(y);
        System.out.println("x");
        for (int i=x.len-1; i>=0; i--)
        {
            System.out.print(x.digits[i]+" | ");
        }
        System.out.println("");
        for (int i=y.len-1; i>=0; i--)
        {
            System.out.print(y.digits[i]+" | ");
        }
        System.out.println("y");
        System.out.println("");

        System.out.println("-------------------------------2-------------------------------");

        BigSignNum z = new BigSignNum(-6);
        BigSignNum v = new BigSignNum(-5);

        System.out.println(z.toString());
        System.out.println(v.toString());
        z.sub(v);
        System.out.println(z.toString());
        z.sub(v);
        System.out.println(z.toString());
        v.sub(z);
        System.out.println(v.toString());
        z.mul(v);
        System.out.println(z.toString());

        System.out.println("-------------------------------3-------------------------------");

        BigFloat d = new BigFloat(-6.5f);
        BigFloat f = new BigFloat(5.3f);

        System.out.println(d.toString());
        System.out.println(f.toString());
        d.add(f);
        System.out.println(d.toString());
        d.sub(f);
        System.out.println(d.toString());
        d.sub(f);
        System.out.println(d.toString());
        f.sub(d);
        System.out.println(f.toString());
        d = new BigFloat(-3.2f);
        f = new BigFloat(2.3f);
        d.mul(f);
        System.out.println(d.toString());

    }
}
