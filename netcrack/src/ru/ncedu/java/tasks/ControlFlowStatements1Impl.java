package ru.ncedu.java.tasks;

import static java.lang.StrictMath.sin;

public class ControlFlowStatements1Impl implements ControlFlowStatements1{
    @Override
    public float getFunctionValue(float x) {
        float f;
        if(x>0) {
            f = (float) (2 * sin(x));
        }
        else {
            f=6-x;
        }
        return f;
    }

    @Override
    public String decodeWeekday(int weekday) {
        String Day = null;
        switch (weekday){
            case 1:
                Day = "Monday";
                break;
            case 2:
                Day ="Tuesday";
                break;
            case 3:
                Day ="Wednesday";
                break;
            case 4:
                Day ="Thursday";
                break;
            case 5:
                Day ="Friday";
                break;
            case 6:
                Day ="Saturday";
                break;
            case 7:
                Day ="Sunday";
                break;
            default:
                break;
        }
        return Day;
    }

    @Override
    public int[][] initArray()  {
        int [][] NewArray = new int[8][5];
        for(int i=0; i<NewArray.length; i++){
            for (int j=0; j<NewArray[i].length; j++){
                NewArray[i][j]=i*j;
            }
        }
        return NewArray;
    }

    @Override
    public int getMinValue(int[][] array) {
        int min = 2147483647;
        for(int i=0; i<array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]<min)
                    min = array[i][j];
            }
        }
        return min;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        double StartDeposit = 1000;
        BankDeposit Deposit = new BankDeposit();
        Deposit.amount = StartDeposit;
        while (Deposit.amount <= 5000){
            Deposit.amount=Deposit.amount*(1+P/100);
            Deposit.years=Deposit.years+1;
        }
        return Deposit;
    }
    public static void main(String[] args) {
        ControlFlowStatements1 object = new ControlFlowStatements1Impl();
        System.out.println(object.getFunctionValue(-1));
        System.out.println(object.decodeWeekday(5));
        System.out.println(object.initArray());
        System.out.println(object.calculateBankDeposit(100));
    }
}

