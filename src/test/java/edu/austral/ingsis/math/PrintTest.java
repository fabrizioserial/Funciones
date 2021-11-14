package edu.austral.ingsis.math;

import edu.austral.ingsis.math.visitor.OperationVisitor;
import edu.austral.ingsis.math.visitor.PrinterOperationVisitor;
import jdk.dynalink.Operation;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        Term term = new Term(new Value(1), new Sum(), new Value(6));

        final String expected = "1 + 6";

        PrinterOperationVisitor printer = new PrinterOperationVisitor();
        term.accept(printer);

        final String result = printer.getVisitorValue().print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {

        Term term = new Term(new Value(12), new Division(), new Value(2));

        final String expected = "12 / 2";

        PrinterOperationVisitor printer = new PrinterOperationVisitor();
        term.accept(printer);

        final String result = printer.getVisitorValue().print();


        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        Term term = new Term(new Value(9), new Division(), new Value(2));
        SubTerm subTerm = new SubTerm(term, new Times(), new Term(new Value(3)));

        final String expected = "(9 / 2) * 3";

        PrinterOperationVisitor printer = new PrinterOperationVisitor();
        subTerm.accept(printer);

        final String result = printer.getVisitorValue().print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        Term term = new Term(new Value(27), new Division(), new Value(6));
        SubTerm subTerm = new SubTerm(term, new Power(), new Term(new Value(2)));

        final String expected = "(27 / 6) ^ 2";

        PrinterOperationVisitor printer = new PrinterOperationVisitor();
        subTerm.accept(printer);

        final String result = printer.getVisitorValue().print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        Term term = new Term( new Absolute() ,new Value("value"));
        SubTerm subTerm = new SubTerm(term, new Substract(), new Term(new Value(8)));

        final String expected = "|value| - 8";

        PrinterOperationVisitor printer = new PrinterOperationVisitor();
        subTerm.accept(printer);

        final String result = printer.getVisitorValue().print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        Term term = new Term( new Absolute() ,new Value("value"));
        SubTerm subTerm = new SubTerm(term, new Substract(), new Term(new Value(8)));

        final String expected = "|value| - 8";

        PrinterOperationVisitor printer = new PrinterOperationVisitor();
        subTerm.accept(printer);

        final String result = printer.getVisitorValue().print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        Term term = new Term( new Value(5),new Substract() ,new Value("i"));
        SubTerm subTerm = new SubTerm(term, new Times(), new Term(new Value(8)));

        final String expected = "(5 - i) * 8";

        PrinterOperationVisitor printer = new PrinterOperationVisitor();
        subTerm.accept(printer);

        final String result = printer.getVisitorValue().print();

        assertThat(result, equalTo(expected));
    }
}
