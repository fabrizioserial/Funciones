package edu.austral.ingsis.math;

public class Value {
    private double value;
    private final String variable;

    public Value(double value) {
        this.value = value;
        this.variable="";
    }

    public Value(String variable) {
        this.variable = variable;
    }

    public Value(String variable, double value){
        this.variable = variable;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getVariable() {
        return variable;
    }

    public boolean isVariable(){
        return !variable.equals("");
    }

    public String print(){
        if(!variable.equals("")){
            return variable;
        } else{
            return String.valueOf(value);
        }
    }
}