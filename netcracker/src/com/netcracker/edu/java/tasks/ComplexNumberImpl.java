package com.netcracker.edu.java.tasks;

import java.util.Arrays;
import java.util.Comparator;

import static java.lang.Math.pow;

public class ComplexNumberImpl implements ComplexNumber{
    private double real;
    private double imagine;
    private CharSequence plus = "+";
    private CharSequence minuse = "-";
    private CharSequence imag = "i";
    String complexString;
    public ComplexNumberImpl(){}
    public ComplexNumberImpl(String value){
        complexString = null;
    }
    public ComplexNumberImpl(double re, double im){
        real=0;
        imagine=0;
    }

    @Override
    public double getRe() {
        return real;
    }

    @Override
    public double getIm() {
        return imagine;
    }

    @Override
    public boolean isReal() {
        if(imagine == 0){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void set(double re, double im) {

        this.real = re;
        this.imagine = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {
        if (value.contains(plus)) containsPluses(value); //содержит плюсы
        else if(!value.contains(plus)) notContainsPluses(value); //не содержит плюсы
        else throw new NumberFormatException();
    }

    private void notContainsPluses(String value) { //в случае отсутствия плюсов
        if (!value.contains(minuse)) notContainsMinuses(value); // не содержит минусы
        else containsMinuses(value); //содержит минусы
    }

    private void containsMinuses(String value) {
        String[] partsOne = value.split("-");
        if (partsOne.length != 0) {
            if (!partsOne[0].equals("")) notStartsWithMinuse(partsOne); //случай a-bi
            else startsWithMinuse(partsOne); //начало с минусом
        } else throw new NumberFormatException();
    }

    private void startsWithMinuse(String[] partsOne) {
        if(partsOne.length == 2) consistsOfTwo(partsOne[1]);
        else if(partsOne.length ==3) consistsOfThree(partsOne);
        else throw new NumberFormatException();
    }

    private void consistsOfThree(String[] partsOne) {
        if (!partsOne[1].matches("^\\D*$")) {
            if(Double.parseDouble(partsOne[1])>0) {
                this.real = -Double.parseDouble(partsOne[1]);
                if (partsOne[2].contains(imag)) {
                    if (partsOne[2].endsWith("i")) {
                        if (partsOne[2].length() - partsOne[2].replace("i", "").length() == 1) {
                            String[] partsTwo = partsOne[2].split("i");
                            if(partsTwo.length!=0) {
                                if (!partsTwo[0].matches("^\\D*$")) {
                                    this.imagine = -Double.parseDouble(partsTwo[0]);
                                } else {
                                    throw new NumberFormatException();
                                }
                            } else {
                                this.imagine = -1;
                            }
                        } else {
                            throw new NumberFormatException();
                        }
                    } else {
                        throw new NumberFormatException();
                    }
                } else {
                    throw new NumberFormatException();
                }
            } else {
                throw new NumberFormatException();
            }
        } else {
            throw new NumberFormatException();
        }
    }

    private void consistsOfTwo(String s) {
        if (!s.contains(imag)) { //real
            if (!s.matches("^\\D*$")) { //только число
                this.real = -Double.parseDouble(s);
            }else {
                throw new NumberFormatException();
            }
        } else if(s.contains(imag)) { //im
            if (s.endsWith("i")) {
                if (s.length() - s.replace("i", "").length() == 1) {
                    String[] partsTwo = s.split("i");
                    if (partsTwo.length != 0) {
                        if (!partsTwo[0].matches("^\\D*$")) {
                            this.imagine = -Double.parseDouble(partsTwo[0]);
                        } else {
                            throw new NumberFormatException();
                        }
                    } else {
                        this.imagine = -1;
                    }
                }
            } else {
                throw new NumberFormatException();
            }
        } else {
            throw new NumberFormatException();
        }
    }

    private void notStartsWithMinuse(String[] partsOne) {
        if (partsOne.length == 2) {
            if (!partsOne[0].matches("^\\D*$")) {
                this.real = Double.parseDouble(partsOne[0]);
                if (partsOne[1].contains(imag)) {
                    if (partsOne[1].endsWith("i")) {
                        if (partsOne[1].length() - partsOne[1].replace("i", "").length() == 1) {
                            if (!partsOne[1].equals("i")) {
                                String[] partsTwo = partsOne[1].split("i");
                                if (!partsTwo[0].matches("^\\D*$")) {
                                    if (Double.parseDouble(partsTwo[0]) > 0) {
                                        this.imagine = -Double.parseDouble(partsTwo[0]);
                                    } else {
                                        throw new NumberFormatException();
                                    }
                                } else {
                                    throw new NumberFormatException();
                                }
                            } else {
                                this.imagine = 1;
                            }
                        } else {
                            throw new NumberFormatException();
                        }
                    } else {
                        throw new NumberFormatException();
                    }
                } else {
                    throw new NumberFormatException();
                }
            } else {
                throw new NumberFormatException();
            }
        } else {
            throw new NumberFormatException();
        }
    }

    private void notContainsMinuses(String value) {
        if (!value.contains(imag)) { //real
            if (!value.matches("^\\D*$")) { //только число
                this.real = Double.parseDouble(value);
            }else {
                throw new NumberFormatException();
            }
        } else if(value.contains(imag)) { //im
            if (value.endsWith("i")) {
                if (value.length() - value.replace("i", "").length() == 1) {
                    String[] partsOne = value.split("i");
                    if (partsOne.length != 0) {
                        if (!partsOne[0].matches("^\\D*$")) {
                            this.imagine = Double.parseDouble(partsOne[0]);
                        } else {
                            throw new NumberFormatException();
                        }
                    } else {
                        this.imagine = 1;
                    }
                }
            } else {
                throw new NumberFormatException();
            }
        } else {
            throw new NumberFormatException();
        }
    }

    private void containsPluses(String value) {
        String[] partsOne = value.split("\\+");
        if (partsOne.length != 0) {
            if (!partsOne[0].equals("")) {
                if (partsOne.length == 2) { //два аргумента
                    if (partsOne[0].contains(minuse)) { //первая часть с минусом
                        if (partsOne[0].length() - partsOne[0].replace("-", "").length() == 1) { //один минус
                            String[] partsTwo = partsOne[0].split("-");
                            if (!partsTwo[1].matches("^\\D*$")) { //только число
                                this.real = -Double.parseDouble(partsTwo[1]);
                                if (partsOne[1].contains(imag)) {
                                    if (partsOne[1].endsWith("i")) {
                                        if (partsOne[1].length() - partsOne[1].replace("i", "").length() == 1) {
                                            String[] partsThree = partsOne[1].split("i");
                                            if(partsThree.length!=0) {
                                                if (!partsThree[0].matches("^\\D*$")) {
                                                    this.imagine = Double.parseDouble(partsThree[0]);
                                                } else {
                                                    throw new NumberFormatException();
                                                }
                                            } else {
                                                this.imagine = 1;
                                            }
                                        } else {
                                            throw new NumberFormatException();
                                        }
                                    } else {
                                        throw new NumberFormatException();
                                    }
                                } else {
                                    throw new NumberFormatException();
                                }
                            } else {
                                throw new NumberFormatException();
                            }
                        } else {
                            throw new NumberFormatException();
                        }
                    } else { //первая часть с плюсом
                        if (!partsOne[0].matches("^\\D*$")) {
                            this.real = Double.parseDouble(partsOne[0]);
                            if (partsOne[1].contains(imag)) {
                                if (partsOne[1].endsWith("i")) {
                                    if (partsOne[1].length() - partsOne[1].replace("i", "").length() == 1) {
                                        if (!partsOne[1].equals("i")) {
                                            String[] partsTwo = partsOne[1].split("i");
                                            if (!partsTwo[0].matches("^\\D*$")) {
                                                if (Double.parseDouble(partsTwo[0]) > 0) {
                                                    this.imagine = Double.parseDouble(partsTwo[0]);
                                                } else {
                                                    throw new NumberFormatException();
                                                }
                                            } else {
                                                throw new NumberFormatException();
                                            }
                                        } else {
                                            this.imagine = 1;
                                        }
                                    } else {
                                        throw new NumberFormatException();
                                    }
                                } else {
                                    throw new NumberFormatException();
                                }
                            } else {
                                throw new NumberFormatException();
                            }
                        } else {
                            throw new NumberFormatException();
                        }
                    }
                } else if (partsOne.length == 1) { //один аргумент
                    if (partsOne[0].contains(minuse)) {
                        if (partsOne[0].length() - partsOne[0].replace("-", "").length() == 1) {
                            String[] partsTwo = partsOne[0].split("-");
                            if (partsTwo.length == 2) {
                                if (!partsTwo[0].matches("^\\D*$")) {
                                    this.real = Double.parseDouble(partsTwo[0]);
                                    if (partsTwo[1].contains(imag)) {
                                        if (partsTwo[1].endsWith("i")) {
                                            if (partsTwo[1].length() - partsTwo[1].replace("i", "").length() == 1) {
                                                String[] partsThree = partsTwo[1].split("i");
                                                if (!partsThree[0].matches("^\\D*$")) {
                                                    this.imagine = -Double.parseDouble(partsThree[0]);
                                                } else {
                                                    throw new NumberFormatException();
                                                }
                                            } else {
                                                throw new NumberFormatException();
                                            }
                                        } else {
                                            throw new NumberFormatException();
                                        }
                                    } else {
                                        throw new NumberFormatException();
                                    }
                                } else {
                                    throw new NumberFormatException();
                                }
                            } else {
                                throw new NumberFormatException();
                            }
                        } else {
                            throw new NumberFormatException();
                        }
                    } else {
                        throw new NumberFormatException();
                    }
                } else {
                    throw new NumberFormatException();
                }
            } else if (partsOne[0].equals("")) { //если начало с +
                if (partsOne.length == 3) { //+a+bi
                    if (!partsOne[1].matches("^\\D*$")) {
                        if(Double.parseDouble(partsOne[1])>0) {
                            this.real = Double.parseDouble(partsOne[1]);
                            if (partsOne[2].contains(imag)) {
                                if (partsOne[2].endsWith("i")) {
                                    if (partsOne[2].length() - partsOne[2].replace("i", "").length() == 1) {
                                        String[] partsTwo = partsOne[2].split("i");
                                        if(partsTwo.length!=0) {
                                            if (!partsTwo[0].matches("^\\D*$")) {
                                                this.imagine = Double.parseDouble(partsTwo[0]);
                                            } else {
                                                throw new NumberFormatException();
                                            }
                                        } else {
                                            this.imagine = 1;
                                        }
                                    } else {
                                        throw new NumberFormatException();
                                    }
                                } else {
                                    throw new NumberFormatException();
                                }
                            } else {
                                throw new NumberFormatException();
                            }
                        } else {
                            throw new NumberFormatException();
                        }
                    } else {
                        throw new NumberFormatException();
                    }
                } else if (partsOne.length == 2) {
                    if (partsOne[1].contains(minuse)) {
                        if (partsOne[1].length() - partsOne[1].replace("-", "").length() == 1) { //один минус
                            String[] partsTwo = partsOne[1].split("-");
                            if (!partsTwo[0].matches("^\\D*$")) { //только число
                                this.real = Double.parseDouble(partsTwo[0]);
                                if (partsTwo[1].contains(imag)) {
                                    if (partsTwo[1].endsWith("i")) {
                                        if (partsTwo[1].length() - partsTwo[1].replace("i", "").length() == 1) {
                                            String[] partsThree = partsTwo[1].split("i");
                                            if(partsThree.length!=0) {
                                                if (!partsThree[0].matches("^\\D*$")) {
                                                    this.imagine = -Double.parseDouble(partsThree[0]);
                                                } else {
                                                    throw new NumberFormatException();
                                                }
                                            } else {
                                                this.imagine = -1;
                                            }
                                        } else {
                                            throw new NumberFormatException();
                                        }
                                    } else {
                                        throw new NumberFormatException();
                                    }
                                } else {
                                    throw new NumberFormatException();
                                }
                            } else {
                                throw new NumberFormatException();
                            }
                        } else {
                            throw new NumberFormatException();
                        }
                    } else if (!partsOne[1].contains(minuse)) { //однозначные числа +a, +bi
                        notContainsMinuses(partsOne[1]);
                    } else {
                        throw new NumberFormatException();
                    }
                } else {
                    throw new NumberFormatException();
                }
            } else {
                throw new NumberFormatException();
            }
        } else {
            throw new NumberFormatException();
        }
    }

    @Override
    public ComplexNumber copy() {
        ComplexNumber a = new ComplexNumberImpl();
        a.set(this.real, this.imagine);
        return a;
    }

    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        ComplexNumber a = new ComplexNumberImpl();
        a.set(this.real, this.imagine);
        return a;
    }
    @Override
    public String toString() {
    if(real==0 && imagine==0){
        return "0";
    } else if (real == 0){
        return Double.toString(imagine) + "i";
    } else if (imagine == 0){
        return Double.toString(real);
    }
    if(imagine>0){
        return Double.toString(real)+"+"+imagine+"i";
    }else {
        return Double.toString(real)+imagine+"i";
    }
    }

    @Override
    public boolean equals(Object other){
        return (other instanceof ComplexNumber) && ((ComplexNumber)other).getRe() == real && ((ComplexNumber)other).getIm() == imagine;
    }

    @Override
    public int compareTo(ComplexNumber other) {
        double squareSum;
        if((squareSum = pow(real,2)+pow(imagine,2)-pow(other.getRe(),2)-pow(other.getIm(),2))==0){
            return 0;
        }else if (squareSum>0){
            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array, new Comparator<ComplexNumber>() {
            @Override
            public int compare(ComplexNumber o1, ComplexNumber o2) {
                return o1.compareTo(o2);
            }
        });
    }

    @Override
    public ComplexNumber negate() {
        set(-real,-imagine);
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        set(real+arg2.getRe(),imagine+arg2.getIm());
        return this;
    }
    /**
     * Multiplies this number by the given complex number arg2. If this number is a+bi and arg2 is c+di then
     * the result of their multiplication is (a*c-b*d)+(b*c+a*d)i<br/>
     * The method should work correctly even if arg2==this.
     * @param arg2 the second operand of the operation
     * @return this number (the result of multiplication)
     */
    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        set(real*arg2.getRe()-imagine*arg2.getIm(),imagine*arg2.getRe()+real*arg2.getIm());
        return this;
    }



    public static void main(String[] args) {
        ComplexNumberImpl compNumber = new ComplexNumberImpl();
        compNumber.set("1.0i");
        System.out.println("Real part: ");
        System.out.println(compNumber.getRe());
        System.out.println("Imaginary part: ");
        System.out.println(compNumber.getIm());
    }
}
