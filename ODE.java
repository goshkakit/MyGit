import org.apache.commons.math3.ode.FirstOrderDifferentialEquations;
import org.apache.commons.math3.ode.FirstOrderIntegrator;
import org.apache.commons.math3.ode.nonstiff.DormandPrince853Integrator;
import org.apache.commons.math3.ode.sampling.StepHandler;
import org.apache.commons.math3.ode.sampling.StepInterpolator;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;


import static java.lang.StrictMath.pow;

public class ODE implements FirstOrderDifferentialEquations {

    private double mu;

    public ODE(double mu) {
        this.mu = mu;
    }

    public int getDimension() {
        return 2;
    }

    public void computeDerivatives(double t, double[] y, double[] yDot) {
        yDot[0] = y[1];
        yDot[1] = mu * (1-pow(y[1],2))*y[1]-y[0];
    }

    public static void main(String[] args) {
        FirstOrderIntegrator dp853 = new DormandPrince853Integrator(1.0e-8, 100.0, 1.0e-10, 1.0e-10);
        FirstOrderDifferentialEquations ode = new ODE(1000);
        double[] y = new double[] { 0.0, 0.001 };
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
        dp853.integrate(ode, 0.0, y, 10000.0, y);
    }
}