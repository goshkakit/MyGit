import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

import static java.lang.StrictMath.exp;
import static java.lang.StrictMath.pow;

public class Border implements FirstOrderDifferentialEquations {
    double h, a;
    public int getDimension() {
        return 2;
    }

    public void computeDerivatives(double t, double[] y, double[] yDot) {
        yDot[0] = y[1];
        yDot[1] = -y[1]-y[0]/t+2*t*exp(t)+4*exp(t);
    }

    public double y0(double h, double a){
        return pow(h,2)*(6*Math.E-2*pow(Math.E,2)-a)+2*pow(Math.E,2)-2*a*h;
    }

    public double shooting(){
        double y0 = Math.E;
        double h = 0.5;
        double a = 0;
        if(y0(h,a) - y0 < 0) {
            while (y0(h, a)-y0 < 0){
                a-=0.1;
            }
        } else {
            while (y0(h, a)-y0 > 0){
                a+=0.1;
            }
        }
        //System.out.print(a);
        double lB = y0(h,a);
        double rB = y0(h,a+0.1);
        for(int i=0; i<10000; i++){
            if((y0(h, lB)-y0)/2 < 0){
                lB += (rB-lB)/2;
            } else {
                rB -= (rB-lB)/2;
            }
            a = a+(rB-lB)/2;
        }
//        System.out.print(" ");
//        System.out.print(a);
        return a;

    }

    public static void main(String[] args) {
        FirstOrderIntegrator dp853 = new DormandPrince853Integrator(1.0e-8, 100.0, 1.0e-10, 1.0e-10);
        Border ode = new Border();

        double[] y = new double[] { Math.E, ode.shooting()};
        StepHandler stepHandler = new StepHandler() {
            ArrayList<String> steps = new ArrayList<String>();

            public void init(double t0, double[] y0, double t) {
            }

            public void handleStep(StepInterpolator interpolator, boolean isLast) {
                double t = interpolator.getCurrentTime();
                double[] y = interpolator.getInterpolatedState();
                if (t > steps.size())
                    steps.add(t + " " + y[0] + " " + y[1]);

                if (isLast) {
                    try {
                        PrintWriter writer = new PrintWriter(new File("results.txt"), "UTF-8");
                        for (String step : steps) {
                            writer.println(step);
                        }
                        writer.close();
                    } catch (Exception e) {
                    }
                }
            }
        };
        dp853.addStepHandler(stepHandler);
        dp853.integrate(ode, 1, y, 20, y);
    }

}
