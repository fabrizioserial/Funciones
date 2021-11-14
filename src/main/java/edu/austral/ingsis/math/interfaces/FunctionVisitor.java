package edu.austral.ingsis.math.interfaces;

import edu.austral.ingsis.math.SubTerm;
import edu.austral.ingsis.math.Term;

public interface FunctionVisitor {
    public void visitSubTerm(SubTerm subTerm);
    public void visitTerm(Term term);
}
