import static java.lang.Math.abs;

public class Interpol {
    double value, sum=0, lagrange, func, mult, divD=0;
    int degree;
    //Привязка значений функции к аргументам
    double valuer(int x){
        switch (x){
            case 1:
                func = 3;
                break;
            case 2:
                func = 7;
                break;
            case 3:
                func = 13;
                break;
            case 4:
                func = 21;
                break;
            case 5:
                func = 31;
                break;
            case 6:
                func = 43;
                break;
            case 7:
                func = 57;
                break;
        }
        return func;
    }
    //подсчет вспомогательных многочленов
    double lagrangeCounter(int input){
        lagrange=1;
        int i;
        for(i=(int) value; i<=(int) value + degree; i++){
            if(i != input){
                lagrange=lagrange*(value-i)/(input-i);
            }
        }
        return lagrange;
    }
    //вычисление интерполяционного многочлена и погрешности
    void approxer(double data, int deg){
        int j;
        sum =0;
        degree = deg;
        value = data;
        for(j=(int) value; j<=(int) value + degree; j++){
            sum = sum+valuer(j)*lagrangeCounter(j);
            divD = divD+valuer(j)/muliplier(j);
        }
        for(j=(int) value; j<=(int) value + degree; j++){
            divD=divD*(value-j);
        }
        System.out.print("Степень интерполяционного многочлена: ");
        System.out.print(degree);
        System.out.print("\n");
        System.out.print("Значение интерполяционного многочлена в заданной точке: ");
        System.out.print(sum);
        System.out.print("\n");
        divD=divD/factorial(degree+1);
        if(abs(divD/sum*100)<0.01){
            System.out.print("Погрешность меньше 0.01%, считать такой порядок не имеет смысла");
        }else {
            System.out.print("Погрешность интерполяции: ");
            System.out.print(divD);
        }
        System.out.print("\n");
    }
    //функция для подсчета частей разделенных разностей
    double muliplier(int k){
        int r;
        mult =1;
        for(r=(int)value; r<=(int)value+degree; r++){
            if(r != k){
                mult=mult*(k-r);
            }
        }
        return mult;
    }
    //не нашел функцию факториала
    public static long factorial(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }

    public static void main(String[] args) {
        Interpol example = new Interpol();
        for(int i=1; i<=3; i++) {
            example.approxer(3.8, i);
        }
    }
}
