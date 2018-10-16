public class Solver {
    double lB=-10,rB=10;
    double function(double numb){
        return (Math.atan(numb-1)+2*numb);
    }
    double mean(double newLeftB, double newRightB){
        return ((newLeftB+newRightB)/2);
    }
    void divider(){
        while ((rB-lB)>1){
            double center = this.mean(lB,rB);
            if(this.function(lB)*this.function(center)<0){
                rB = center;
            } else if(this.function(rB)*this.function(center)<0){
                lB= center;
            }
        }
    }
    double solutionFinder(){
        double solution=((lB+rB)/2);
        for(int i=0; i<100; i++){
            solution = -Math.atan(solution-1)/2;
        }
        return solution;
    }
    public static void main(String[] args) {
        Solver n = new Solver();
        n.divider();
        System.out.print(n.solutionFinder());
    }
}
