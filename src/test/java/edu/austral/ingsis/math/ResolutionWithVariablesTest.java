package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.OperationVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        Term term = new Term( new Value(1),new Sum() ,new Value("x", 3));
        OperationVisitor operatorVisitor = new OperationVisitor();
        term.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Term term = new Term( new Value(12),new Division() ,new Value("div", 4));
        OperationVisitor operatorVisitor = new OperationVisitor();
        term.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Term term = new Term( new Value(9),new Division() ,new Value("x", 3));
        SubTerm subTerm = new SubTerm(term, new Times(), new Term(new Value("y",4)));
        OperationVisitor operatorVisitor = new OperationVisitor();
        subTerm.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Term term = new Term( new Value(27),new Division() ,new Value("a", 9));
        SubTerm subTerm = new SubTerm(term, new Power(), new Term(new Value("b",3)));
        OperationVisitor operatorVisitor = new OperationVisitor();
        subTerm.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Term term = new Term( new Value(1),new Division() ,new Value(2));
        SubTerm subTerm = new SubTerm(new Term(new Value("z",36)), new Power(), term);
        OperationVisitor operatorVisitor = new OperationVisitor();
        subTerm.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        Term term = new Term( new Absolute() ,new Value("value", 8));
        SubTerm subTerm = new SubTerm(term, new Substract(), new Term(new Value(8)));
        OperationVisitor operatorVisitor = new OperationVisitor();
        subTerm.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {
        Term term = new Term( new Absolute() ,new Value("value", 8));
        SubTerm subTerm = new SubTerm(term, new Substract(), new Term(new Value(8)));
        OperationVisitor operatorVisitor = new OperationVisitor();
        subTerm.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Term term = new Term( new Value(5),new Substract() ,new Value("i", 2));
        SubTerm subTerm = new SubTerm(term, new Times(), new Term(new Value(8)));
        OperationVisitor operatorVisitor = new OperationVisitor();
        subTerm.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();
        assertThat(result, equalTo(24d));
    }
}
