package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.ListVariablesVisitor;
import edu.austral.ingsis.math.visitor.OperationVisitor;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        Term term = new Term(new Value(1),new Sum(), new Value(6));
        OperationVisitor operatorVisitor = new OperationVisitor();
        term.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Term term = new Term(new Value(12),new Division(), new Value(2));
        OperationVisitor operatorVisitor = new OperationVisitor();
        term.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Term term = new Term( new Value(9),new Division() ,new Value(2));
        SubTerm subTerm = new SubTerm(term, new Times(), new Term(new Value(3)));
        OperationVisitor operatorVisitor = new OperationVisitor();
        subTerm.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Term term = new Term( new Value(27),new Division() ,new Value(6));
        SubTerm subTerm = new SubTerm(term, new Power(), new Term(new Value(2)));
        OperationVisitor operatorVisitor = new OperationVisitor();
        subTerm.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Term term = new Term( new Value(1),new Division() ,new Value(2));
        SubTerm subTerm = new SubTerm(new Term(new Value(36)), new Power(), term);
        OperationVisitor operatorVisitor = new OperationVisitor();
        subTerm.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        Term term = new Term( new Absolute(),new Value(136));
        OperationVisitor operatorVisitor = new OperationVisitor();
        term.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        Term term = new Term( new Absolute(),new Value(-136));
        OperationVisitor operatorVisitor = new OperationVisitor();
        term.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Term term = new Term( new Value(5),new Substract() ,new Value(5));
        SubTerm subTerm = new SubTerm(term, new Times(), new Term(new Value(8)));
        OperationVisitor operatorVisitor = new OperationVisitor();
        subTerm.accept(operatorVisitor);
        final Double result = operatorVisitor.getVisitorValue().getValue();

        assertThat(result, equalTo(0d));
    }
}
