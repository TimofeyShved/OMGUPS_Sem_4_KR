public class BigNum {
    static final int base = 100;
    static final int len = 4;
    byte [] digits;
    boolean sign=true;

    BigNum(){
        digits = new byte[len];
    }

    BigNum(long x){
        this();
        fromLong(x);
    }

    BigNum(BigNum bigNum){
        digits = bigNum.digits.clone();
    }

    void fromLong(long x){
        for(int i=0; x>0; i++){
            digits[i] = (byte) (x % base);
            x = x / base;
        }
    }

    void add(BigNum x){
        byte c=0;
        int sum;
        for(int i=0; i<len; i++){
            sum = digits[i]+x.digits[i]+c;
            digits[i] = (byte) (sum % base);
            c = (byte) (sum / base);
        }
    }

    void sub(BigNum x){
        int subtract, down=0;
        byte[] newer_num = new byte[len],
                num_1= new byte[len],
                num_2= new byte[len];
        if (isLarger(x)){
            num_1=digits;
            num_2=x.digits;
        }
        else {
            sign=false;
            num_2=digits;
            num_1=x.digits;
        }
        for(int i=0; i<len; i++){
            subtract = num_1[i] - num_2[i];
            if (subtract<0){
                subtract+=base;
                                                                                //System.out.print(num_1[i] + "| " + num_2[i] +" | " );
                                                                                //System.out.println(subtract);
                num_1[i+1]-=1;
            }
            num_1[i]=(byte) subtract;
        }
        this.digits=num_1;
    }

    void mul(BigNum x){
        int mulPrivate;
        BigNum newer_num = new BigNum();
        BigNum summ_num = new BigNum();
        BigNum num_shift = new BigNum();
        byte[] num_1= new byte[len],
                num_2= new byte[len];
        num_1=digits;
        num_2=x.digits;

        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                mulPrivate=num_1[i]*num_2[j];
                for(int k=0; k<len; k++){
                    num_shift.digits[k]=0;
                    newer_num.digits[k]=0;
                }
                                                                                //System.out.println(mulPrivate+" mp");
                newer_num.fromLong(mulPrivate);
                                                                        //System.out.println(newer_num.digits[0]+" nw");
                for(int k=0; k<len; k++){
                    num_shift=mulDigit(newer_num.digits[k],(j+i+k));
                    //System.out.println("");
                    //System.out.println(num_shift.digits[k]);
                    summ_num.add(num_shift);
                }

                        //System.out.println(summ_num.digits[k]+"___"+i);
                        //System.out.println("");
                //System.out.println(summ_num.digits[0]+"___"+summ_num.digits[1]+"___"+summ_num.digits[2]+"___"+summ_num.digits[3]+"___");
            }
            //System.out.println(summ_num.digits[0]+"___"+summ_num.digits[1]+"___"+summ_num.digits[2]+"___"+summ_num.digits[3]+"___");
        }
        //System.out.println(summ_num.digits[0]+"___"+summ_num.digits[1]+"___"+summ_num.digits[2]+"___"+summ_num.digits[3]+"___");
        digits = summ_num.digits;
    }

    boolean isLarger(BigNum x){
        for(int i=len-1; i>=0; i--){
                                                                //System.out.println(digits[i] + "| " + x.digits[i] +" | " );
            if (digits[i]!=x.digits[i]) {
                if (digits[i]>x.digits[i]) {
                    return true;
                }
                else {
                    return false;
                }

            }
        }
        return false;
    }

    private BigNum mulDigit(byte digit, int shift) {
                                                            //System.out.print(digit);
                                                            //System.out.print(shift);
                                                            //System.out.println("");
        BigNum bigNummulDigit = new BigNum();
            bigNummulDigit.digits[0] = digit;
        bigNummulDigit.shift(shift);
                                                        //System.out.print(bigNummulDigit.digits[0]+" "+bigNummulDigit.digits[1]+" "+bigNummulDigit.digits[2]+" "+bigNummulDigit.digits[3] );
        return bigNummulDigit;
    }

    void shift(int x){
        if(x>=0){
            for (int j=0; j<x; j++) {
                for (int i = len-1; i>0; i--) {
                    //System.out.print("+");
                    digits[i] = digits[i-1];
                }
                //System.out.print("-");
                digits[0]=0;
            }
        }
        else {
            for (int j=0; j>x; j--) {
                for (int i = 0; i<len-1; i++) {
                    //System.out.print("+");
                    digits[i] = digits[i+1];
                }
                //System.out.print("-");
                digits[3]=0;
            }
        }
    }

    void division(BigNum x){
        int division_pub;
        BigNum newer_num = new BigNum();
        BigNum summ_num = new BigNum();
        BigNum num_shift = new BigNum();
        byte[] num_1= new byte[len],
                num_2= new byte[len];
        num_1 = this.digits;
        num_2 = x.digits;
        for(int i=0; i<len; i++){
            for(int j=0; j<len; j++){
                division_pub=Math.round(num_1[i]/num_2[j]);
                for(int k=0; k<len; k++){
                    num_shift.digits[k]=0;
                    newer_num.digits[k]=0;
                }

                newer_num.fromLong(division_pub);

            }
        }
        division_pub=Math.round(division_priv);
        BigNum bigNum_division = new BigNum(division_pub);
        this.digits=bigNum_division.digits;
    }


    public String toString(){
        String result = "";
        int i = len - 1;
        while(i>0 & digits[i]==0)
            i--;
        while(i>=0) {
            String d = ((Byte) digits[i--]).toString();
            if(d.length()==1)
                d = "0" + d;
            result = result + d;
        }
        if(result.charAt(0)=='0')
            return result.substring(1);
        return result;
    }

}
