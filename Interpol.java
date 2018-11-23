public class Interpol {
    int argument,leftBorder,rightBorder;
    double value, sum;
    double valuer(int x){
        switch (x){
            case 1:
                value = 3;
                break;
            case 2:
                value = 7;
                break;
            case 3:
                value = 13;
                break;
            case 4:
                value = 21;
                break;
            case 5:
                value = 31;
                break;
            case 6:
                value = 43;
                break;
            case 7:
                value = 57;
                break;
        }
        return value;
    }
    double linearApprox(double input){
        leftBorder = (int) input;
        rightBorder = leftBorder+1;
        return (valuer(leftBorder)*(input-rightBorder)-valuer(rightBorder)*(input-leftBorder))/(leftBorder - rightBorder);
    }
    double squareApprox(double input){
        leftBorder = (int) input - 1;
        rightBorder = (int) input + 1;
        return valuer(leftBorder)*(input-(int)input)*(input-rightBorder)/((leftBorder-(int)input)*(leftBorder-rightBorder))+valuer((int)input)*(input-leftBorder)*(input-rightBorder)/(((int)input-leftBorder)*((int)input-rightBorder))+valuer(rightBorder)*((input-leftBorder)*(input-(int)input))/((rightBorder-leftBorder)*(rightBorder-(int)input));
    }
    double cubeApprox(double input){
        leftBorder = (int) input - 1;
        argument = (int) input + 1;
        rightBorder = argument + 1;
        return valuer(leftBorder)*(input-(int)input)*(input-argument)*(input-rightBorder)/((leftBorder-(int)input)*(leftBorder-argument)*(leftBorder-rightBorder))+valuer((int)input)*(input-leftBorder)*(input-argument)*(input-rightBorder)/(((int)input-leftBorder)*((int)input-argument)*((int)input-rightBorder))+valuer(argument)*(input-leftBorder)*(input-(int)input)*(input-rightBorder)/((argument-leftBorder)*(argument-(int)input)*(argument-rightBorder))+valuer(rightBorder)*(input-leftBorder)*(input-(int)input)*(input-argument)/((rightBorder-leftBorder)*(rightBorder-(int)input)*(rightBorder-argument));
    }
    public static void main(String[] args) {
        Interpol example = new Interpol();
        System.out.print(example.linearApprox(5.8));
        System.out.print(" ");
        System.out.print(example.squareApprox(5.8));
        System.out.print(" ");
        System.out.print(example.cubeApprox(5.8));
    }
}
