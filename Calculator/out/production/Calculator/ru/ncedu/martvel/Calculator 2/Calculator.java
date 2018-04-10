package ru.ncedu.martvel.Calculator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public double arg,result;
    String operation;

    public double getArg() {
        Scanner inDouble = new Scanner(System.in);
        System.out.println("Enter a number: ");
        try{
            arg = inDouble.nextDouble();
        } catch (InputMismatchException e){
            System.out.println("Wrong data");
            System.exit(0);
        }
        return arg;
    }
    public String getOperation(){
        Scanner  inChar = new Scanner(System.in);
        System.out.println("Enter an operation");
        operation = inChar.nextLine();
        return operation;
    }

    public double calculation() throws InputMismatchException {
        try {
            double arg1=this.getArg();
            this.getOperation();
            if(operation.equals("+")) return summing(arg1);
            else if(operation.equals("-")) return differencing(arg1);
            else if(operation.equals("*")) return multiplicating(arg1);
            else if(operation.equals("/")) return dividing(arg1);
            else if(operation.equals("^")) return exponentiation(arg1);
            else throw new InputMismatchException();
        } catch (InputMismatchException e){
            System.out.println("No such operation");
            System.exit(0);
        }
        return 0;
    }

    private double exponentiation(double arg1){
        Exponentiation exponentiation = new Exponentiation();
        double arg2=this.getArg();
        result = exponentiation.inv(arg1,arg2);
        System.out.println("Result of exponentiation: ");
        return result;
    }

    private double dividing(double arg1){
        Division division = new Division();
        double arg2=this.getArg();
        if(arg2 == 0){
            System.out.println("ru.ncedu.martvel.Calculator.Division by 0");
            System.exit(0);
        }
        result = division.div(arg1,arg2);
        System.out.println("Result of division:");
        return result;


    }
    private double multiplicating(double arg1){
        Multiplication multiplication = new Multiplication();
        double arg2=this.getArg();
        result = multiplication.mult(arg1,arg2);
        System.out.println("Result of multiplication:");
        return result;
    }
    private double differencing(double arg1) {
        Difference difference = new Difference();
        double arg2=this.getArg();
        result = difference.minuse(arg1,arg2);
        System.out.println("Result of differencing:");
        return result;
    }
    private double summing(double arg1) {
        Sum sum = new Sum();
        double arg2=this.getArg();
        result = sum.plus(arg1,arg2);
        System.out.println("Result of summing:");
        return result;
    }

    public static void main(String[] args) {
        Calculator equation = new Calculator();
        equation.calculation();
        System.out.println(equation.result);
    }
}

