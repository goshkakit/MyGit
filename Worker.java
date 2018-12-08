public class Worker {
    double step, point=0.1, sum=0;
    void errorDefiner(double error){
        step = Math.sqrt(12*error/(241.666*8.9)); //h=sqrt(12*E/(max(f'')*(b-a)))
    }
    double function(double arg){
        return Math.log(1+arg)/(arg*Math.sqrt(arg));
    }
    void integralCounter(double error){
        this.errorDefiner(error);
        while(point<9){
            sum = sum + step*(function(point+step)+function(point))/2; //I=sum(h/2*(f(x+step)+f(x)))
            point = point + step;
        }
        System.out.print(sum+0.62231);
        System.out.print("±");
        System.out.print(error+0.00002);
    }
    public static void main(String[] args) {
        Worker w = new Worker();
        w.integralCounter(0.00008);
    }
}