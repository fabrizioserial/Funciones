package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.*;
import edu.austral.ingsis.math.interfaces.FunctionTerm;
import edu.austral.ingsis.math.interfaces.FunctionVisitor;
import edu.austral.ingsis.math.interfaces.Operand;

public class OperationVisitor implements FunctionVisitor {

    Value result;

    @Override
    public void visitSubTerm(SubTerm subTerm) {
        Operand operand = subTerm.getOperand();

        FunctionTerm leftTerm = subTerm.getLeftTerm();
        OperationVisitor leftVisitor = new OperationVisitor();
        leftTerm.accept(leftVisitor);
        Value leftValue = leftVisitor.getVisitorValue();

        FunctionTerm rightTerm = subTerm.getRightTerm();
        OperationVisitor rightVisitor = new OperationVisitor();
        rightTerm.accept(rightVisitor);
        Value rightValue = rightVisitor.getVisitorValue();



        result = operand.operate(leftValue,rightValue);
    }

    @Override
    public void visitTerm(Term term) {
        Operand operand = term.getOperand();

        Value leftValue = term.getLeftValue();
        Value rightValue = term.getRightValue();

        if (operand == null){
            operand = new Times();
            rightValue = new Value(1);
        }

        result = operand.operate(leftValue, rightValue);
    }

    public Value getVisitorValue(){
        return result;
    }
}