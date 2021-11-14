package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.Absolute;
import edu.austral.ingsis.math.SubTerm;
import edu.austral.ingsis.math.Term;
import edu.austral.ingsis.math.Value;
import edu.austral.ingsis.math.interfaces.FunctionTerm;
import edu.austral.ingsis.math.interfaces.FunctionVisitor;
import edu.austral.ingsis.math.interfaces.Operand;

public class PrinterOperationVisitor implements FunctionVisitor {
    Value result;

    @Override
    public void visitSubTerm(SubTerm subTerm) {
        Operand operand = subTerm.getOperand();

        FunctionTerm leftTerm = subTerm.getLeftTerm();
        PrinterOperationVisitor leftVisitor = new PrinterOperationVisitor();
        leftTerm.accept(leftVisitor);
        Value leftValue = leftVisitor.getVisitorValue();

        FunctionTerm rightTerm = subTerm.getRightTerm();
        PrinterOperationVisitor rightVisitor = new PrinterOperationVisitor();
        rightTerm.accept(rightVisitor);
        Value rightValue = rightVisitor.getVisitorValue();

        String leftParenthesis = leftValue.print();
        if (leftValue.print().split(" ").length > 1){
            leftParenthesis = "(" + leftValue.print() + ")";
        }
        String rightParenthesis = rightValue.print();
        if (rightTerm.print().split(" ").length > 1){
            rightParenthesis = "(" + rightValue.print() + ")";
        }

        result = new Value(leftParenthesis + " " + operand.print() + " " + rightParenthesis);

    }

    @Override
    public void visitTerm(Term term) {
        Operand operand = term.getOperand();

        Value leftValue = term.getLeftValue();
        Value rightValue = term.getRightValue();


        if ( operand == null ){
            result = new Value( leftValue.isVariable() ? leftValue.getVariable() : Integer.toString((int)leftValue.getValue()) );
        }else if ( operand instanceof Absolute ){
            result = new Value(
                    operand.print() +
                            ( leftValue.isVariable() ? leftValue.getVariable() : (int)leftValue.getValue()) +
                            operand.print());
        }
        else{
            result = new Value(  ( leftValue.isVariable() ? leftValue.getVariable() : (int)leftValue.getValue())
                    + " " + operand.print() + " " +
                    ( rightValue.isVariable() ? rightValue.getVariable() : (int)rightValue.getValue()) );
        }

    }

    public Value getVisitorValue() {
        return result;
    }
}
