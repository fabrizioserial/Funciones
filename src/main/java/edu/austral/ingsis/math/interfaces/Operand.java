package edu.austral.ingsis.math.interfaces;

import edu.austral.ingsis.math.Value;

public interface Operand {
    public Value operate(Value v1, Value v2);
    public String print();
}