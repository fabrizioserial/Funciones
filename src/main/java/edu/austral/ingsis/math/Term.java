package edu.austral.ingsis.math;

import edu.austral.ingsis.math.interfaces.FunctionTerm;
import edu.austral.ingsis.math.interfaces.FunctionVisitor;
import edu.austral.ingsis.math.interfaces.Operand;

public class Term implements FunctionTerm {
    Value leftValue;
    Value rightValue;
    Operand operand;

    public Term(Value leftValue,Operand operand , Value rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;
        this.operand = operand;
    }

    public Term(Value leftValue){
        this.leftValue = leftValue;
        this.rightValue = null;
        this.operand = null;
    }

    public Term (Operand operand, Value leftValue){
        if (!(operand instanceof Absolute )){
            throw new RuntimeException("Error: bad operands");
        }
        this.operand = operand;
        this.leftValue = leftValue;
        this.rightValue = new Value("");
    }

    @Override
    public void accept(FunctionVisitor visitor) {
        visitor.visitTerm(this);
    }

    @Override
    public String print() {
        if (operand instanceof Absolute) {
            return operand.print() + " " + leftValue.print() + " " + operand.print();
        }
        if (operand == null) {
            return leftValue.print();
        }
        return leftValue.print() +" "+ operand.print() +" "+ rightValue.print();
    }

    public Value getLeftValue() {
        return leftValue;
    }

    public Value getRightValue() {
        return rightValue;
    }

    public Operand getOperand() {
        return operand;
    }
}