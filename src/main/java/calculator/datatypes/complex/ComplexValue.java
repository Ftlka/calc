package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;

public class ComplexValue extends AbstractValue
{
    public final double real;
    public final double imaginary;

    public ComplexValue(double real_, double imaginary_)
    {
        real = real_;
        imaginary = imaginary_;
    }
    //think of an irrational field

    public AbstractValue add(AbstractValue operand) throws OperationNotSupportedException {
        double realOperand = ((ComplexValue) operand).real;
        double imaginaryOperand = ((ComplexValue) operand).imaginary;
        return new ComplexValue(real+realOperand, imaginary+imaginaryOperand);
    }

    public AbstractValue sub(AbstractValue operand) throws OperationNotSupportedException {
        double realOperand = ((ComplexValue) operand).real;
        double imaginaryOperand = ((ComplexValue) operand).imaginary;
        return new ComplexValue(real-realOperand, imaginary-imaginaryOperand);
    }

    public AbstractValue mul(AbstractValue operand) throws OperationNotSupportedException {
        double realOperand = ((ComplexValue) operand).real;
        double imaginaryOperand = ((ComplexValue) operand).imaginary;
        double multReal = real*realOperand - imaginary*imaginaryOperand;
        double multImaginary = imaginary*realOperand + real*imaginaryOperand;
        return new ComplexValue(multReal, multImaginary); //from Wikipedia
    }

    public AbstractValue div(AbstractValue operand) throws DivisionByZeroException, OperationNotSupportedException {
        double realOperand = ((ComplexValue) operand).real;
        double imaginaryOperand = ((ComplexValue) operand).imaginary;
        if ((realOperand*realOperand + imaginaryOperand*imaginaryOperand)==0)
            throw new DivisionByZeroException();
        double divReal = (real*realOperand + imaginary*imaginaryOperand)/
                (realOperand*realOperand + imaginaryOperand*imaginaryOperand);
        double divImaginary = (imaginary*realOperand - real*imaginaryOperand)/
                (realOperand*realOperand + imaginaryOperand*imaginaryOperand);
        return new ComplexValue(divReal, divImaginary); //again from Wiki
    }

    public String toString() {
        return real+" + "+imaginary+"i";
    }
}
