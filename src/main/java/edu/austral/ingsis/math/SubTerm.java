package edu.austral.ingsis.math;

import edu.austral.ingsis.math.interfaces.FunctionTerm;
import edu.austral.ingsis.math.interfaces.FunctionVisitor;
import edu.austral.ingsis.math.interfaces.Operand;

import java.util.ArrayList;
import java.util.List;

public class SubTerm implements FunctionTerm {
    FunctionTerm leftTerm;
    FunctionTerm rightTerm;
    Operand operand;

    public SubTerm(FunctionTerm leftTerm, Operand operand, FunctionTerm rightTerm) {
        this.leftTerm = leftTerm;
        this.rightTerm = rightTerm;
        this.operand = operand;
    }


    @Override
    public void accept(FunctionVisitor visitor) {
        visitor.visitSubTerm(this);
    }

    @Override
    public String print() {
        return leftTerm.print() +" "+ operand.print() +" "+ rightTerm.print();
    }

    public FunctionTerm getLeftTerm() {
        return leftTerm;
    }

    public FunctionTerm getRightTerm() {
        return rightTerm;
    }

    public Operand getOperand() {
        return operand;
    }
}