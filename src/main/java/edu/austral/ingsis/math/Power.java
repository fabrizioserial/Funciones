package edu.austral.ingsis.math;

import edu.austral.ingsis.math.interfaces.Operand;

public class Power implements Operand {
    @Override
    public Value operate(Value v1, Value v2) {
        return new Value( Math.pow(v1.getValue(),v2.getValue()));
    }

    @Override
    public String print() {
        return "^";
    }
}