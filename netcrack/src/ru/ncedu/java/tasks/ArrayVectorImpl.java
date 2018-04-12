package ru.ncedu.java.tasks;

import java.util.Arrays;

import static java.lang.Math.sqrt;


public class ArrayVectorImpl implements ArrayVector {

    public ArrayVectorImpl() {}

    private double mass[];
    int i;
    @Override
    public void set(double... elements) {
        mass = new double[elements.length];
        for (i = 0; i < elements.length; i++) {
            mass[i] = elements[i];
            //System.out.println(mass[i]);
        }
    }
    @Override
    public double[] get() {
      return mass;
    }
    
    @Override
    public ArrayVector clone() {
        ArrayVector otherVector = new ArrayVectorImpl();
        otherVector.set(mass);
        return otherVector;
    }

    @Override
    public int getSize() {
        return mass.length;
    }

    @Override
    public void set(int index, double value) {
        if(index < 0) {
            return;
        } else if(index + 1 > mass.length) {
            double[] temp = new double[index + 1];
            System.arraycopy(mass, 0, temp, 0, mass.length);
            mass = temp;
        }
        mass[index] = value;
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        return mass[index];
    }

    @Override
    public double getMax() {
        double maxElem = mass[0];
        for (double elem: mass){
            if(elem>maxElem){
                maxElem=elem;
            }
        }
        return maxElem;
    }

    @Override
    public double getMin() {
        double minElem = mass[0];
        for (double elem: mass){
            if(elem<minElem){
                minElem=elem;
            }
        }
        return minElem;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(mass);
    }

    @Override
    public void mult(double factor) {
        for(i=0; i<mass.length; i++){
            mass[i]*=factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        int realSize;
        if(anotherVector.getSize()>mass.length){
            realSize = mass.length;
        }
        else{
            realSize = anotherVector.getSize();
        }
        for(i=0; i<realSize; i++){
            mass[i]+=anotherVector.get(i);
        }
        return this; //??
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        int realSize;
        double part = 0;
        if(anotherVector.getSize()>mass.length){
            realSize = mass.length;
        }
        else{
            realSize = anotherVector.getSize();
        }
        for(i=0; i<realSize; i++){
            part += (mass[i] * anotherVector.get(i));
           //System.out.println(part);
        }
        return part;
    }

    @Override
    public double getNorm() {
        return sqrt(scalarMult(this));
    }
    public static void main(String[] args) {
        ArrayVectorImpl array = new ArrayVectorImpl();
        double[] elements = {3,4};
        array.set(elements);
        System.out.println(array.get());
        array.clone();
        System.out.println(array.getSize());
       // array.set(4,1);
        //System.out.println(array.mass[2]);
        array.getMax();
        array.getMin();
        //array.sortAscending();
       // array.mult(2);
       // ArrayVectorImpl arr2 = new ArrayVectorImpl();
       // double[] elements2 = {3,5,5};
       // arr2.set(elements2);
       // System.out.println(array.scalarMult(arr2));
        System.out.println(array.getNorm());
    }
}

