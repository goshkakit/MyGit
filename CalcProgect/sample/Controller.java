package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import static java.lang.Math.pow;

public class Controller {
    public javafx.scene.control.TextField TextField;
    public Button ButtonDegree;
    public Button ButtonReverse;
    private String workString = "";
    public String operation;
    public  String secondArg;
    public double result;
    public boolean isFirst = true;
    public Button ButtonZero;
    public Button ButtonComma;
    public Button ButtonEquals;
    public Button ButtonPlus;
    public Button ButtonOne;
    public Button ButtonTwo;
    public Button ButtonThree;
    public Button ButtonFour;
    public Button ButtonFive;
    public Button ButtonSix;
    public Button ButtonSeven;
    public Button ButtonEight;
    public Button ButtonNine;
    public Button ButtonDel;
    public Button ButtonMinuse;
    public Button ButtonMult;
    public Button ButtonDiv;

    public void initialize() {
        TextField.setOnKeyTyped(Event::consume);
    }

    public void addZero(MouseEvent mouseEvent) {
        if(TextField.getText().length()<10){
            workString = TextField.getText();
            if (!workString.equals("0")) {
                String newWorkString = workString + "0";
                TextField.setText(newWorkString);
            }
        }
    }

    public void addComma(MouseEvent mouseEvent) {
        if(TextField.getText().length()<10) {
            workString = TextField.getText();
            if (workString.length() != 0 && !workString.contains(".")) {
                String newWorkString = workString + ".";
                TextField.setText(newWorkString);
            }
        }
    }

    public void Del(MouseEvent mouseEvent) {
        TextField.clear();
        result = 0;
        operation = null;
        isFirst = true;
    }

    public void Plus(MouseEvent mouseEvent) {
        if(!TextField.getText().equals("")) {
            if(isFirst) {
                isFirst = false;
                addFirst();
                operation = "+";
            }
        }
    }

    public void Minuse(MouseEvent mouseEvent) {
        if(!TextField.getText().equals("")) {
            if(isFirst) {
                isFirst = false;
                addFirst();
                operation = "-";
            }
        }
    }
    
    public void Mult(MouseEvent mouseEvent) {
        if(!TextField.getText().equals("")) {
            if(isFirst) {
                isFirst = false;
                addFirst();
                operation = "*";
            }
        }
    }
    
    public void Div(MouseEvent mouseEvent) {
        if (!TextField.getText().equals("")) {
            if(isFirst) {
                isFirst = false;
                addFirst();
                operation = "/";
            }
        }
    }

    public void Degree(MouseEvent mouseEvent) {
        if (!TextField.getText().equals("")) {
            if(isFirst) {
                isFirst = false;
                addFirst();
                operation = "^";
            }
        }
    }

    public void Reverse(MouseEvent mouseEvent) {
        if (!TextField.getText().equals("")) {
            workString = TextField.getText();
            if (Double.parseDouble(workString) != 0) {
                result = 1 / Double.parseDouble(workString);
                TextField.setText(String.valueOf(result));
            } else {
                TextField.setText("ERROR");
            }
        }
    }

    private void addFirst() {
        workString = TextField.getText();
        result = Double.parseDouble(workString);
        TextField.clear();
    }

    public void addOne(MouseEvent mouseEvent) {
        if(TextField.getText().length()<10) {
            workString = TextField.getText();
            String newWorkString = workString + "1";
            TextField.setText(newWorkString);
        }
    }

    public void addTwo(MouseEvent mouseEvent) {
        if(TextField.getText().length()<10) {
            workString = TextField.getText();
            String newWorkString = workString + "2";
            TextField.setText(newWorkString);
        }
    }

    public void addThree(MouseEvent mouseEvent) {
        if(TextField.getText().length()<10) {
            workString = TextField.getText();
            String newWorkString = workString + "3";
            TextField.setText(newWorkString);
        }
    }

    public void addFour(MouseEvent mouseEvent) {
        if(TextField.getText().length()<10) {
            workString = TextField.getText();
            String newWorkString = workString + "4";
            TextField.setText(newWorkString);
        }
    }

    public void addFive(MouseEvent mouseEvent) {
        if(TextField.getText().length()<10) {
            workString = TextField.getText();
            String newWorkString = workString + "5";
            TextField.setText(newWorkString);
        }
    }

    public void addSix(MouseEvent mouseEvent) {
        if(TextField.getText().length()<10) {
            workString = TextField.getText();
            String newWorkString = workString + "6";
            TextField.setText(newWorkString);
        }
    }

    public void addSeven(MouseEvent mouseEvent) {
        if(TextField.getText().length()<10) {
            workString = TextField.getText();
            String newWorkString = workString + "7";
            TextField.setText(newWorkString);
        }
    }

    public void addEight(MouseEvent mouseEvent) {
        if(TextField.getText().length()<10) {
            workString = TextField.getText();
            String newWorkString = workString + "8";
            TextField.setText(newWorkString);
        }
    }

    public void addNine(MouseEvent mouseEvent) {
        if(TextField.getText().length()<10) {
            workString = TextField.getText();
            String newWorkString = workString + "9";
            TextField.setText(newWorkString);
        }
    }
    
    public void Equal(MouseEvent mouseEvent) {
        if(operation.equals("+")) summing();
        else if(operation.equals("-")) subtraction();
        else if(operation.equals("*")) multiplication();
        else if(operation.equals("/")) division();
        else if(operation.equals("^")) degree();
        isFirst = true;
        operation = null;
    }

    private void degree() {
        workString = TextField.getText();
        result = pow(result,Double.parseDouble(workString));
        TextField.setText(String.valueOf(result));
    }

    private void division() {
        workString = TextField.getText();
        if(Double.parseDouble(workString) != 0) {
            result = result / Double.parseDouble(workString);
            TextField.setText(String.valueOf(result));
        }else {
            TextField.setText("ERROR");
        }
    }

    private void multiplication() {
        workString = TextField.getText();
        result = result * Double.parseDouble(workString);
        TextField.setText(String.valueOf(result));
    }

    private void subtraction() {
        workString = TextField.getText();
        result = result - Double.parseDouble(workString);
        TextField.setText(String.valueOf(result));
    }

    private void summing() {
        workString = TextField.getText();
        result += Double.parseDouble(workString);
        TextField.setText(String.valueOf(result));
    }
}
