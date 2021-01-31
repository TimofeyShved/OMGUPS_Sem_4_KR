import java.lang.*;

class BigFloat extends BigNum{
    private boolean isPositive;
    private long shift;

    BigFloat(float x){
        super();
        shift = -(long) (Math.log10(1000000/Math.abs(x))/2);
        long xl = (long) (x*Math.pow(100, -shift));
        if(x>0)
            isPositive = true;
        else {
            xl = -xl;
            isPositive = false;
        }
        fromLong(xl);
        normalize();
    }

    BigFloat(BigFloat x){
        super(x);
        isPositive = x.isPositive;
        shift = x.shift;
    }

    private void calcShift(BigFloat tmp){
        if(shift < tmp.shift)
            shift((int) (shift-tmp.shift));
        else
            tmp.shift((int) (tmp.shift - shift));
        shift = Math.max(shift, tmp.shift);
    }

    void normalize(){
        int i;
        for(i=len-1; i>=0 && digits[i]==0; i--)
            ;
        shift(len-i-1);
        shift = shift - len + i + 1;
    }

    void add(BigFloat x) {
        BigFloat tmp = new BigFloat(x);
        if (tmp.isPositive) {
            calcShift(tmp);
            if (isPositive)
                super.add(tmp);
            else if (super.isLarger(tmp))
                super.sub(tmp);
            else {
                ((BigNum)tmp).sub(this);
                digits = tmp.digits.clone();
                shift = tmp.shift;
                isPositive = false;
            }
            normalize();
        } else {
            tmp.isPositive = true;
            sub(tmp);
        }
    }

    void sub(BigFloat x) {
        BigFloat tmp = new BigFloat(x);
        calcShift(tmp);
        if(x.isPositive)
        {
            if(isPositive)
            {
                if(super.isLarger(tmp))
                {
                    super.sub(tmp);
                }
                else {
                    ((BigNum)tmp).sub(this);
                    digits = tmp.digits.clone();
                    shift = tmp.shift;
                    isPositive = false;
                }
            }
            else {
                super.add(tmp);
            }
        }
        else {
            if(isPositive)
            {
                super.add(tmp);
            }
            else {
                if(super.isLarger(tmp))
                {
                    super.sub(tmp);
                }
                else {
                    ((BigNum)tmp).sub(this);
                    digits = tmp.digits.clone();
                    shift = tmp.shift;
                    isPositive = false;
                }
            }
        }
        normalize();
    }

    void mul(BigFloat x){
        BigFloat tmp = new BigFloat(x);
        calcShift(tmp);
        tmp.shift(-2);
        //System.out.println(tmp.toString()+"x");
        super.shift(-2);
        super.mul((BigNum)tmp);
        //System.out.println(super.toString());
        shift=shift+tmp.shift+4;
        if(((x.isPositive)&&(isPositive))||((!x.isPositive)&&(!isPositive)))
        {
            isPositive=true;
        }
        else {
            isPositive=false;
        }
        normalize();
    }

    void division(BigFloat x){
        float num_1=Float.parseFloat(this.toString());
        float num_2=Float.parseFloat(x.toString());
        float division_priv = num_1/num_2;
        BigFloat bigNum_division = new BigFloat(division_priv);
        this.digits=bigNum_division.digits;
        this.isPositive=bigNum_division.isPositive;
        this.shift=bigNum_division.shift;
    }

    public String toString(){
        String sign = isPositive?"":"-";
        return sign + super.toString() + "e" + ((Long)(shift*2)).toString();
    }
}
