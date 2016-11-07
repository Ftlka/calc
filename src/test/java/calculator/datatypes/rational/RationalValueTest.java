package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.datatypes.rational.RationalValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class RationalValueTest {
//TESTS FOR ADD
    @Test
    public void add1() throws Exception {
        AbstractValue val = (new RationalValue(1,2)).add(new RationalValue(1,3));
        assertTrue(((RationalValue)val).numerator==5 && ((RationalValue)val).denominator==6);
    }

    @Test
    public void add2() throws Exception {
        AbstractValue val = (new RationalValue(-1,2)).add(new RationalValue(1,3));
        assertTrue(((RationalValue)val).numerator==-1 && ((RationalValue)val).denominator==6);
    }

    @Test
    public void addAnti() throws Exception {
        AbstractValue val = (new RationalValue(1,6)).add(new RationalValue(-1,6));
        assertTrue(((RationalValue)val).numerator==0 && ((RationalValue)val).denominator==0);
    }

    @Test
    public void addNeedToSimplify() throws Exception {
        AbstractValue val = (new RationalValue(2,14)).add(new RationalValue(3,7));
        assertTrue(((RationalValue)val).numerator==4 && ((RationalValue)val).denominator==7);
    }

    @Test
    public void addZeroAsSecond() throws Exception {
        AbstractValue val = (new RationalValue(1,2)).add(new RationalValue(0,0));
        assertTrue(((RationalValue)val).numerator==1 && ((RationalValue)val).denominator==2);
    }

    @Test
    public void addZeroAsFirst() throws Exception {
        AbstractValue val = (new RationalValue(0,0)).add(new RationalValue(-5,7));
        assertTrue(((RationalValue)val).numerator==-5 && ((RationalValue)val).denominator==7);
    }

    @Test
    public void addTwoZeros() throws Exception {
        AbstractValue val = (new RationalValue(0,0)).add(new RationalValue(0,0));
        assertTrue(((RationalValue)val).numerator==0 && ((RationalValue)val).denominator==0);
    }

    @Test
    public void addWithZeroAtNum() throws Exception {
        AbstractValue val = (new RationalValue(0,10)).add(new RationalValue(4,10));
        assertTrue(((RationalValue)val).numerator==2 && ((RationalValue)val).denominator==5);
    }

    @Test
    public void addWithZeroAtDenom() throws Exception {
        AbstractValue val = (new RationalValue(3,0)).add(new RationalValue(4,10));
        assertTrue(((RationalValue)val).numerator==2 && ((RationalValue)val).denominator==5);
    }
//END OF TESTS FOR ADD
//TESTS FOR SUB
    @Test
    public void sub1() throws Exception {
        AbstractValue val = (new RationalValue(5,4)).sub(new RationalValue(1,4));
        assertTrue(((RationalValue)val).numerator==1 && ((RationalValue)val).denominator==1);
    }

    @Test
    public void sub2() throws Exception {
        AbstractValue val = (new RationalValue(9,3)).sub(new RationalValue(10,5));
        assertTrue(((RationalValue)val).numerator==1 && ((RationalValue)val).denominator==1);
    }

    @Test
    public void sub3() throws Exception {
        AbstractValue val = (new RationalValue(13,14)).sub(new RationalValue(1,14));
        assertTrue(((RationalValue)val).numerator==6 && ((RationalValue)val).denominator==7);
    }

    @Test
    public void subEqual3() throws Exception {
        AbstractValue val = (new RationalValue(13,14)).sub(new RationalValue(13,14));
        assertTrue(((RationalValue)val).numerator==0 && ((RationalValue)val).denominator==0);
    }

    @Test
    public void subSecondNegative() throws Exception {
        AbstractValue val = (new RationalValue(5,7)).sub(new RationalValue(-2,7));
        assertTrue(((RationalValue)val).numerator==1 && ((RationalValue)val).denominator==1);
    }

    @Test
    public void subAllZeros() throws Exception {
        AbstractValue val = (new RationalValue(0,0)).sub(new RationalValue(0,0));
        assertTrue(((RationalValue)val).numerator==0 && ((RationalValue)val).denominator==0);
    }

    @Test
    public void subFirstIsZero() throws Exception {
        AbstractValue val = (new RationalValue(0,4)).sub(new RationalValue(1,4));
        assertTrue(((RationalValue)val).numerator==-1 && ((RationalValue)val).denominator==4);
    }

    @Test
    public void subSecondIsZero() throws Exception {
        AbstractValue val = (new RationalValue(3,4)).sub(new RationalValue(1,0));
        assertTrue(((RationalValue)val).numerator==3 && ((RationalValue)val).denominator==4);
    }
//END OF TESTS FOR SUB
//TESTS FOR MUL
    @Test
    public void mul1() throws Exception {
        AbstractValue val = (new RationalValue(1,2)).mul(new RationalValue(1,4));
        assertTrue(((RationalValue)val).numerator==1 && ((RationalValue)val).denominator==8);
    }

    @Test
    public void mul2() throws Exception {
        AbstractValue val = (new RationalValue(5,6)).mul(new RationalValue(2,7));
        assertTrue(((RationalValue)val).numerator==5 && ((RationalValue)val).denominator==21);
    }

    @Test
    public void mulDoubleValue() throws Exception {
        AbstractValue val = (new RationalValue(5,3)).mul(new RationalValue(2,1));
        assertTrue(((RationalValue)val).numerator==10 && ((RationalValue)val).denominator==3);
    }

    @Test
    public void mulOneNegative() throws Exception {
        AbstractValue val = (new RationalValue(-4,7)).mul(new RationalValue(5,2));
        assertTrue(((RationalValue)val).numerator==-10 && ((RationalValue)val).denominator==7);
    }

    @Test
    public void mulBothNegative() throws Exception {
        AbstractValue val = (new RationalValue(-1,1)).mul(new RationalValue(-1,7));
        assertTrue(((RationalValue)val).numerator==1 && ((RationalValue)val).denominator==7);
    }

    @Test
    public void mulOneZero() throws Exception {
        AbstractValue val = (new RationalValue(-1,0)).mul(new RationalValue(53,2));
        assertTrue(((RationalValue)val).numerator==0 && ((RationalValue)val).denominator==0);
    }

    @Test
    public void mulBothZero() throws Exception {
        AbstractValue val = (new RationalValue(-1,0)).mul(new RationalValue(0,2));
        assertTrue(((RationalValue)val).numerator==0 && ((RationalValue)val).denominator==0);
    }

    @Test
    public void mulMakeOne() throws Exception {
        AbstractValue val = (new RationalValue(2,17)).mul(new RationalValue(34,4));
        assertTrue(((RationalValue)val).numerator==1 && ((RationalValue)val).denominator==1);
    }
//END OF TESTS FOR MUL
//TESTS FOR DIV
    @Test
    public void div1() throws Exception {
        AbstractValue val = (new RationalValue(2,5)).div(new RationalValue(2,5));
        assertTrue(((RationalValue)val).numerator==1 && ((RationalValue)val).denominator==1);
    }

    @Test
    public void div2() throws Exception {
        AbstractValue val = (new RationalValue(7,8)).div(new RationalValue(8,1));
        assertTrue(((RationalValue)val).numerator==7 && ((RationalValue)val).denominator==64);
    }

    @Test
    public void div3() throws Exception {
        AbstractValue val = (new RationalValue(8,1)).div(new RationalValue(2,1));
        assertTrue(((RationalValue)val).numerator==4 && ((RationalValue)val).denominator==1);
    }

    @Test
    public void divOneNegative() throws Exception {
        AbstractValue val = (new RationalValue(-1,1)).div(new RationalValue(1,1));
        assertTrue(((RationalValue)val).numerator==-1 && ((RationalValue)val).denominator==1);
    }

    @Test
    public void divBothNegative() throws Exception {
        AbstractValue val = (new RationalValue(-1,1)).div(new RationalValue(-1,1));
        assertTrue(((RationalValue)val).numerator==1 && ((RationalValue)val).denominator==1);
    }

    @Test(expected=DivisionByZeroException.class)
    public void divOneZero() throws Exception {
        AbstractValue val = (new RationalValue(0,0)).div(new RationalValue(154,155));
        assertTrue(((RationalValue)val).numerator==0 && ((RationalValue)val).denominator==0);
    }

    @Test(expected=DivisionByZeroException.class)
    public void divBothZero() throws Exception {
        AbstractValue val = (new RationalValue(0,0)).div(new RationalValue(0,155));
        assertTrue(((RationalValue)val).numerator==0 && ((RationalValue)val).denominator==0);
    }

}