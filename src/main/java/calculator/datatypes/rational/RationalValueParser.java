package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;


public class RationalValueParser implements AbstractValueParser{

    public AbstractValue parse(String value) throws ParseValueException {
        try {
            String[] parameters = value.split("/");
            if (parameters.length != 2) throw new ParseValueException();
            return new RationalValue(Integer.parseInt(parameters[0]), Integer.parseInt(parameters[1]));
        } catch (NumberFormatException exception) {
            throw new ParseValueException();
        }
    }

    public String getDatatypeName() {
        return "Дробные числа.";
    }
}
