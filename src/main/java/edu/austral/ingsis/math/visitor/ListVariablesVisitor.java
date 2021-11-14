package edu.austral.ingsis.math.visitor;

import edu.austral.ingsis.math.SubTerm;
import edu.austral.ingsis.math.Term;
import edu.austral.ingsis.math.Value;
import edu.austral.ingsis.math.interfaces.FunctionVisitor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ListVariablesVisitor implements FunctionVisitor {

    private final List<String> variables = new ArrayList<>();

    @Override
    public void visitSubTerm(SubTerm subTerm) {
        ListVariablesVisitor leftTerm = new ListVariablesVisitor();
        ListVariablesVisitor rightTerm = new ListVariablesVisitor();

        subTerm.getLeftTerm().accept(leftTerm);
        subTerm.getRightTerm().accept(rightTerm);

        variables.addAll(leftTerm.getVariables());
        variables.addAll(rightTerm.getVariables());
    }

    @Override
    public void visitTerm(Term term) {
        if(term.getLeftValue().isVariable()){
            variables.add(term.getLeftValue().print());
        }
        if(term.getRightValue() != null && term.getRightValue().isVariable()){
            variables.add(term.getRightValue().print());
        }

    }

    public List<String> getVariables() {
        return variables;
    }
}