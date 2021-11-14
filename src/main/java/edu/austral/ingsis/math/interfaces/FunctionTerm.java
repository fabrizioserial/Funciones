package edu.austral.ingsis.math.interfaces;
import java.util.List;

public interface FunctionTerm {
    public void accept(FunctionVisitor visitor);
    public String print();
}