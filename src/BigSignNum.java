public class BigSignNum {
    private BigNum num;
    private boolean isPositive;

    BigSignNum(long x) {
        if(x>0) {
            num = new BigNum(x);
            isPositive = true;
        } else {
            num = new BigNum(-x);
            isPositive = false;
        }
    }

    BigSignNum(BigSignNum x) {
        num = new BigNum(x.num);
        isPositive = x.isPositive;
    }

    void add(BigSignNum x){
        if(x.isPositive)
            if(isPositive)
                num.add(x.num);
            else
            if(num.isLarger(x.num))
                num.sub(x.num);
            else {
                BigNum tmp = new BigNum(x.num);
                tmp.sub(num);
                num = new BigNum(tmp);
                isPositive = false;
            }
        else {
            BigSignNum tmp = new BigSignNum(x);
            tmp.isPositive = true;
            sub(tmp);
        }
    }

    void sub(BigSignNum x){
        if(x.isPositive)
        {
            if(isPositive)
            {
                if(num.isLarger(x.num))
                {
                    num.sub(x.num);
                }
                else {
                    num.sub(x.num);
                    isPositive=false;
                }
            }
            else {
                num.add(x.num);
            }
        }
        else {
            if(isPositive)
            {
                num.add(x.num);
            }
            else {
                if(num.isLarger(x.num))
                {
                    num.sub(x.num);
                }
                else {
                    num.sub(x.num);
                    isPositive=true;
                }
            }

        }

    }

    //void mul(BigSignNum x, int shift){
    void mul(BigSignNum x){
        num.mul(x.num);
        if(((x.isPositive)&&(isPositive))||((!x.isPositive)&&(!isPositive)))
        {
            isPositive=true;
        }
        else {
            isPositive=false;
        }
    }

    void division(BigSignNum x){
        num.division(x.num);
        if(((x.isPositive)&&(isPositive))||((!x.isPositive)&&(!isPositive)))
        {
            isPositive=true;
        }
        else {
            isPositive=false;
        }
    }

    public String toString(){
        if(isPositive)
            return num.toString();
        else
            return "-"+num.toString();
    }

}
