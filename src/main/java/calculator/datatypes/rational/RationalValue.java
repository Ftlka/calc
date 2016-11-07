package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;

public class RationalValue extends AbstractValue
{
    public final int numerator;
    public final int denominator;

    public RationalValue(int numerator_, int denominator_)
    {
        super();
        numerator = numerator_;
        denominator = denominator_;//Where do we check that denominator isn't 0?
    }

    public AbstractValue add(AbstractValue operand) throws OperationNotSupportedException {
        int numerator1 = ((RationalValue) operand).numerator;//to type faster
        int denominator1 = ((RationalValue) operand).denominator;//to type faster
        if (numerator==0 || denominator==0)//if both something anywhere is zero
            return new RationalValue(numerator1, denominator1).simplify();
        else if(numerator1==0 || denominator1==0)
            return new RationalValue(numerator , denominator).simplify();
        int commonDenominator = denominator1 * denominator;//to find a common denominator
        return new RationalValue(numerator * denominator1 + numerator1 * denominator, commonDenominator).simplify();
    }

    public AbstractValue sub(AbstractValue operand) throws OperationNotSupportedException {
        //same as add
        int numerator1 = ((RationalValue) operand).numerator;//to type faster
        int denominator1 = ((RationalValue) operand).denominator;//to type faster
        if (numerator==0 || denominator==0)//if both something anywhere is zero
            return new RationalValue(-numerator1, denominator1).simplify();
        else if(numerator1==0 || denominator1==0)
            return new RationalValue(numerator , denominator).simplify();
        int commonDenominator = denominator1 * denominator;//to find a common denominator
        return new RationalValue(numerator * denominator1 - numerator1 * denominator, commonDenominator).simplify();
    }

    public AbstractValue mul(AbstractValue operand) throws OperationNotSupportedException {
        return new RationalValue(numerator*((RationalValue)operand).numerator,
                denominator*((RationalValue)operand).denominator).simplify();
    }

    public AbstractValue div(AbstractValue operand) throws DivisionByZeroException, OperationNotSupportedException {
        if (denominator*((RationalValue)operand).numerator==0) throw new DivisionByZeroException();
        return new RationalValue(numerator*((RationalValue)operand).denominator,
                denominator*((RationalValue)operand).numerator).simplify();
    }

    public String toString() {
        return numerator+"/"+denominator;
    }

    public AbstractValue simplify()//makes it look more correct
    {

        int num = numerator;
        int denom = denominator;
        if (num==0||denom==0) return new RationalValue(0,0);
        if (denom<0)
        {
            num*=-1;
            denom*=-1;
        }
        int gcd = findGCD(num, denom);
        if(gcd>0)
            return (new RationalValue(num/gcd, denom/gcd));
        else return (new RationalValue(num,denom));
    }

    public static int findGCD(int number1, int number2)//to find what are we dividing by
    {
        /*if (number1==number2)
            return number1;
        while(number1!=number2)
        {
            if(number1>number2)
                number1=number1-number2;
            else
                number2=number2-number1;
        }
        return number1;*/
        return number2 == 0 ? number1 : findGCD(number2, number1 % number2);
    }
}
