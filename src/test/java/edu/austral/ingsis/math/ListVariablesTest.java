package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.ListVariablesVisitor;
import edu.austral.ingsis.math.visitor.OperationVisitor;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class ListVariablesTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldListVariablesFunction1() {
        Term term = new Term(new Value(1), new Sum(), new Value(6));

        ListVariablesVisitor listVisitor = new ListVariablesVisitor();
        term.accept(listVisitor);

        final List<String> result = listVisitor.getVariables();

        assertThat(result, empty());
    }

    /**
     * Case 12 / div
     */
    @Test
    public void shouldListVariablesFunction2() {
        Term term = new Term(new Value(1), new Division(), new Value("div"));

        ListVariablesVisitor listVisitor = new ListVariablesVisitor();
        term.accept(listVisitor);

        final List<String> result = listVisitor.getVariables();

        assertThat(result, containsInAnyOrder("div"));
    }

    /**
     * Case (9 / x) * y
     */
    @Test
    public void shouldListVariablesFunction3() {
        Term term = new Term(new Value(9), new Division(), new Value("x"));
        SubTerm subterm = new SubTerm(term, new Times() , new Term(new Value("y")));
        ListVariablesVisitor listVisitor = new ListVariablesVisitor();
        subterm.accept(listVisitor);

        final List<String> result = listVisitor.getVariables();

        assertThat(result, containsInAnyOrder("x", "y"));
    }

    /**
     * Case (27 / a) ^ b
     */
    @Test
    public void shouldListVariablesFunction4() {
        Term term = new Term(new Value(27), new Division(), new Value("a"));
        SubTerm subterm = new SubTerm(term, new Power() , new Term(new Value("b")));
        ListVariablesVisitor listVisitor = new ListVariablesVisitor();
        subterm.accept(listVisitor);

        final List<String> result = listVisitor.getVariables();

        assertThat(result, containsInAnyOrder("a", "b"));
    }

    /**
     * Case z ^ (1/2)
     */
    @Test
    public void shouldListVariablesFunction5() {
        Term term = new Term(new Value(1), new Division(), new Value(2));
        SubTerm subterm = new SubTerm(new Term(new Value("z")), new Power() , term);
        ListVariablesVisitor listVisitor = new ListVariablesVisitor();
        subterm.accept(listVisitor);

        final List<String> result = listVisitor.getVariables();

        assertThat(result, containsInAnyOrder("z"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction6() {
        Term term = new Term(new Absolute(), new Value("value"));
        SubTerm subterm = new SubTerm(term, new Substract() , new Term(new Value(8)));
        ListVariablesVisitor listVisitor = new ListVariablesVisitor();
        subterm.accept(listVisitor);

        final List<String> result = listVisitor.getVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldListVariablesFunction7() {
        Term term = new Term(new Absolute(), new Value("value"));
        SubTerm subterm = new SubTerm(term, new Substract() , new Term(new Value(8)));
        ListVariablesVisitor listVisitor = new ListVariablesVisitor();
        subterm.accept(listVisitor);

        final List<String> result = listVisitor.getVariables();

        assertThat(result, containsInAnyOrder("value"));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldListVariablesFunction8() {
        Term term = new Term(new Value(5),new Substract(), new Value("i"));
        SubTerm subterm = new SubTerm(term, new Times() , new Term(new Value(8)));
        ListVariablesVisitor listVisitor = new ListVariablesVisitor();
        subterm.accept(listVisitor);

        final List<String> result = listVisitor.getVariables();

        assertThat(result, containsInAnyOrder("i"));
    }
}
