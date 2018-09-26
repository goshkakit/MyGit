import Jama.*;

import static java.lang.Math.abs;

public class Solver {
    double sum1=0,sum2=0;
    private double[][] array = {{0, -7, 7}, {-7, -9, -5}, {7, -5, -1}};
    Matrix A = new Matrix(array);
    Matrix x = Matrix.random(3,1);
    private Matrix mult(int iterNumb, double accurPerc) {
        double lambdaOld = 1;
        double lambdaNew = 1;
        for (int i = 0; i < iterNumb; i++) {
            x = A.times(x);
            lambdaOld = lambdaNew;
            lambdaNew = this.lambda();
            double lambdaPerc = (lambdaNew-lambdaOld)*100/lambdaOld;
            if (abs(lambdaPerc) < accurPerc/2 ){
                break;
            }
        }
        return x;
    }

    private double lambda() {
        for(int i =0; i<=2; i++){
            sum1+=A.times(x).get(i,0)*x.get(i,0);
            sum2+=x.get(i,0)*x.get(i,0);
        }
        return sum1/sum2;
    }

    public static void main(String[] args) {
        System.out.println("Running unit test:");
        int amountOfP = 0;
        int amountOfTests = 10000;
        for (int i = 0; i<amountOfTests; i++) {
            Solver s = new Solver();
            s.mult(10000, 10);
            if(abs(abs(s.lambda())-12.962)>1) {
               // System.out.println(abs(s.lambda()));
                amountOfP++;
            }
        }
        System.out.println(String.format("Loss: %.2f %%",(double)amountOfP/amountOfTests*100));
        Solver m = new Solver();
        m.mult(10000, 10);
        System.out.print("Result: ");
        System.out.println(abs(m.lambda()));
    }
}