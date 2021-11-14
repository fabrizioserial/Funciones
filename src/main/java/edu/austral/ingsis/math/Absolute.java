package edu.austral.ingsis.math;

import edu.austral.ingsis.math.interfaces.Operand;

public class Absolute implements Operand {
    @Override
    public Value operate(Value v1, Value v2) {
        return new Value(Math.abs(v1.getValue()));
    }

    @Override
    public String print() {
        return "|";
    }
}
