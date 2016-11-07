package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.datatypes.rational.RationalValue;
import org.junit.Test;

import static org.junit.Assert.*;


public class ComplexValueTest {
//TESTS FOR ADD
    @Test
    public void add1() throws Exception {
        AbstractValue val = (new ComplexValue(1,1)).add(new ComplexValue(1,1));
        assertTrue(((ComplexValue)val).real==2 && ((ComplexValue)val).imaginary==2);
    }

    @Test
    public void add2() throws Exception {
        AbstractValue val = (new ComplexValue(2,3)).add(new ComplexValue(1,5));
        assertTrue(((ComplexValue)val).real==3 && ((ComplexValue)val).imaginary==8);
    }

    @Test
    public void add3() throws Exception {
        AbstractValue val = (new ComplexValue(7,4)).add(new ComplexValue(2,3));
        assertTrue(((ComplexValue)val).real==9 && ((ComplexValue)val).imaginary==7);
    }

    @Test
    public void addDoubleValues() throws Exception {
        AbstractValue val = (new ComplexValue(1.2,4.23)).add(new ComplexValue(1.3,2.37));
        double epsilon = 0.00000001;
        assertTrue(((ComplexValue)val).real==2.5 && (((ComplexValue)val).imaginary-6.6)<epsilon);
    }

    @Test
    public void addNoImaginary() throws Exception {
        AbstractValue val = (new ComplexValue(2,0)).add(new ComplexValue(5,0));
        assertTrue(((ComplexValue)val).real==7 && ((ComplexValue)val).imaginary==0);
    }

    @Test
    public void addLessThanZero() throws Exception {
        AbstractValue val = (new ComplexValue(-2,-3)).add(new ComplexValue(-1,-1));
        assertTrue(((ComplexValue)val).real==-3 && ((ComplexValue)val).imaginary==-4);
    }

    @Test
    public void addMakeZeros() throws Exception {
        AbstractValue val = (new ComplexValue(-6,2)).add(new ComplexValue(6,-2));
        assertTrue(((ComplexValue)val).real==0 && ((ComplexValue)val).imaginary==0);
    }
//END OF TESTS FOR ADD
//TESTS FOR SUB
    @Test
    public void sub1() throws Exception {
        AbstractValue val = (new ComplexValue(2,2)).sub(new ComplexValue(1,1));
        assertTrue(((ComplexValue)val).real==1 && ((ComplexValue)val).imaginary==1);
    }

    @Test
    public void sub2() throws Exception {
        AbstractValue val = (new ComplexValue(5,4)).sub(new ComplexValue(3,2));
        assertTrue(((ComplexValue)val).real==2 && ((ComplexValue)val).imaginary==2);
    }

    @Test
    public void sub3() throws Exception {
        AbstractValue val = (new ComplexValue(10,1)).sub(new ComplexValue(3,6));
        assertTrue(((ComplexValue)val).real==7 && ((ComplexValue)val).imaginary==-5);
    }

    @Test
    public void subMakeZero() throws Exception {
        AbstractValue val = (new ComplexValue(2,2)).sub(new ComplexValue(2,2));
        assertTrue(((ComplexValue)val).real==0 && ((ComplexValue)val).imaginary==0);
    }

    @Test
    public void subZeroReal() throws Exception {
        AbstractValue val = (new ComplexValue(0,34)).sub(new ComplexValue(0,20));
        assertTrue(((ComplexValue)val).real==0 && ((ComplexValue)val).imaginary==14);
    }

    @Test
    public void subZeroImaginary() throws Exception {
        AbstractValue val = (new ComplexValue(17,0)).sub(new ComplexValue(18,0));
        assertTrue(((ComplexValue)val).real==-1 && ((ComplexValue)val).imaginary==0);
    }

    @Test
    public void subDouble() throws Exception {
        AbstractValue val = (new ComplexValue(1.5,3.15)).sub(new ComplexValue(2.5,3.12));
        double epsilon = 0.00000001;
        assertTrue(((ComplexValue)val).real==-1 && Math.abs(((ComplexValue)val).imaginary-0.03)<epsilon);
    }

    @Test
    public void subNegative() throws Exception {
        AbstractValue val = (new ComplexValue(-7,-7)).sub(new ComplexValue(-4,-3));
        assertTrue(((ComplexValue)val).real==-3 && ((ComplexValue)val).imaginary==-4);
    }
//END OF TESTS FOR SUB
//TESTS FOR MUL
    @Test
    public void mul1() throws Exception {
        AbstractValue val = (new ComplexValue(1,1)).mul(new ComplexValue(1,1));
        assertTrue(((ComplexValue)val).real==0 && ((ComplexValue)val).imaginary==2);
    }

    @Test
    public void mul2() throws Exception {
        AbstractValue val = (new ComplexValue(2,5)).mul(new ComplexValue(6,1));
        assertTrue(((ComplexValue)val).real==7 && ((ComplexValue)val).imaginary==32);
    }

    @Test
    public void mul3() throws Exception {
        AbstractValue val = (new ComplexValue(3,3)).mul(new ComplexValue(2,2));
        assertTrue(((ComplexValue)val).real==0 && ((ComplexValue)val).imaginary==12);
    }

    @Test
    public void mul4() throws Exception {
        AbstractValue val = (new ComplexValue(2,7)).mul(new ComplexValue(2,7));
        assertTrue(((ComplexValue)val).real==-45 && ((ComplexValue)val).imaginary==28);
    }

    @Test
    public void mulZeroReal() throws Exception {
        AbstractValue val = (new ComplexValue(0,13)).mul(new ComplexValue(0,1));
        assertTrue(((ComplexValue)val).real==-13 && ((ComplexValue)val).imaginary==0);
    }

    @Test
    public void mulZeroImaginary() throws Exception {
        AbstractValue val = (new ComplexValue(10,0)).mul(new ComplexValue(5,0));
        assertTrue(((ComplexValue)val).real==50 && ((ComplexValue)val).imaginary==0);
    }

    @Test
    public void mulOneRandomZero() throws Exception {
        AbstractValue val = (new ComplexValue(32,4)).mul(new ComplexValue(0,1));
        assertTrue(((ComplexValue)val).real==-4 && ((ComplexValue)val).imaginary==32);
    }

    @Test
    public void mulNegativeValues() throws Exception {
        AbstractValue val = (new ComplexValue(-4,-9)).mul(new ComplexValue(-9,-4));
        assertTrue(((ComplexValue)val).real==0 && ((ComplexValue)val).imaginary==97);
    }
//END OF TESTS FOR MUL
//TESTS FOR DIV
    @Test
    public void div1() throws Exception {
        AbstractValue val = (new ComplexValue(1,1)).div(new ComplexValue(1,1));
        assertTrue(((ComplexValue)val).real==1 && ((ComplexValue)val).imaginary==0);
    }

    @Test
    public void div2() throws Exception {
        AbstractValue val = (new ComplexValue(2,5)).div(new ComplexValue(2,5));
        assertTrue(((ComplexValue)val).real==1 && ((ComplexValue)val).imaginary==0);
    }

    @Test
    public void div3() throws Exception {
        AbstractValue val = (new ComplexValue(16,2)).div(new ComplexValue(4,2));
        assertTrue(((ComplexValue)val).real==3.4 && ((ComplexValue)val).imaginary==-1.2);
    }

    @Test
    public void div4() throws Exception {
        AbstractValue val = (new ComplexValue(2,7)).div(new ComplexValue(1,1));
        assertTrue(((ComplexValue)val).real==4.5 && ((ComplexValue)val).imaginary==2.5);
    }

    @Test
    public void divZeroReal() throws Exception {
        AbstractValue val = (new ComplexValue(0,2)).div(new ComplexValue(0,4));
        assertTrue(((ComplexValue)val).real==0.5 && ((ComplexValue)val).imaginary==0);
    }

    @Test
    public void divZeroImaginary() throws Exception {
        AbstractValue val = (new ComplexValue(14,0)).div(new ComplexValue(7,0));
        assertTrue(((ComplexValue)val).real==2 && ((ComplexValue)val).imaginary==0);
    }

    @Test(expected= DivisionByZeroException.class)
    public void divAllZero() throws Exception {
        AbstractValue val = (new ComplexValue(0,0)).div(new ComplexValue(0,0));
        assertTrue(((ComplexValue)val).real==2 && ((ComplexValue)val).imaginary==0);
    }

    @Test
    public void divNegativeValues1() throws Exception {
        AbstractValue val = (new ComplexValue(-5,-3)).div(new ComplexValue(-2,-4));
        assertTrue(((ComplexValue)val).real==1.1 && ((ComplexValue)val).imaginary==-0.7);
    }

    @Test
    public void divNegativeValues2() throws Exception {
        AbstractValue val = (new ComplexValue(-10,-12)).div(new ComplexValue(5,6));
        assertTrue(((ComplexValue)val).real==-2 && ((ComplexValue)val).imaginary==0);
    }

}