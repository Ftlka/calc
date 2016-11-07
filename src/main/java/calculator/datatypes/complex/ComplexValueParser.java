package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;
import calculator.datatypes.integer.IntegerValue;

public class ComplexValueParser implements AbstractValueParser {

    public AbstractValue parse(String value) throws ParseValueException {
        try {
            value = value.substring(1,value.length() - 1);
            String[] parameters = value.split(",");
            if (parameters.length != 2) throw new ParseValueException();
            return new ComplexValue(Double.parseDouble(parameters[0]),Double.parseDouble(parameters[1]));
        } catch (NumberFormatException exception) {
            throw new ParseValueException();
        }
    }

    public String getDatatypeName() {
        return "Комплексные числа.";
    }

}
