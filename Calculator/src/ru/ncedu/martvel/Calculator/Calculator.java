package ru.ncedu.martvel.Calculator;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    private double arg,result;
    private int calcCounter=0;
    String operation;

    private double getArg() {
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
    private String getOperation(){
        Scanner  inChar = new Scanner(System.in);
        System.out.println("Enter an operation:");
        operation = inChar.nextLine();
        return operation;
    }

    public double calculation() throws InputMismatchException {
        double arg1;
        try {
            if(calcCounter == 0) {
                arg1 = this.getArg();
                calcCounter++;
            } else {
                arg1 = result;
            }
            this.getOperation();
            if(operation.equals("+")) System.out.println(summing(arg1));
            else if(operation.equals("-")) System.out.println(differencing(arg1));
            else if(operation.equals("*")) System.out.println(multiplicating(arg1));
            else if(operation.equals("/")) System.out.println(dividing(arg1));
            else if(operation.equals("^")) System.out.println(exponentiation(arg1));
            else if(operation.equals("sin")) System.out.println(sin(arg1));
            else throw new InputMismatchException();
        } catch (InputMismatchException e){
            System.out.println("No such operation");
            System.exit(0);
        }
        this.continueProcess();
        return 0;
    }

    private void continueProcess() throws InputMismatchException{
        System.out.println("Do you want to continue equations?\nPrint yes to continue, or print no");
        String yes = "yes";
        String no = "no";
        String question;
        Scanner command = new Scanner(System.in);
        try {
            question = command.next();
            if (question.equals(yes)) {
                this.calculation();
            } else if (question.equals(no)){
                System.out.println("Calculation finished, result is "+ result);
            }  else
                throw new InputMismatchException();
        } catch (InputMismatchException e){
            System.out.println("Can't continue");
            System.exit(0);
        }
    }
    private double sin(double arg1){
        Sin sin = new Sin();
        System.out.println("Result of taking sin(): ");
        return result = sin.sinus(arg1);
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
            System.out.println("Division by 0");
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
    }
}