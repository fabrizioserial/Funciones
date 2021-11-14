package edu.austral.ingsis.math;

import edu.austral.ingsis.math.interfaces.Operand;

public class Division implements Operand {

    @Override
    public Value operate(Value v1, Value v2) {
        return new Value(v1.getValue()/v2.getValue());
    }

    @Override
    public String print() {
        return "/";
    }
}