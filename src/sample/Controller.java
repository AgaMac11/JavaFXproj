package sample;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField firstNumber;
    @FXML
    private TextField secondNumber;
    @FXML
    private TextField lastNumber;
    @FXML
    private Label wynikLabel;
    @FXML
    private NumberAxis xAxis = new NumberAxis();
    @FXML
    private NumberAxis yAxis = new NumberAxis();
    @FXML
    private LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

    private double a,b,c;
    private double x1, x2;

    public void initialize(){


    }
    @FXML
    public void drawLine(){
        XYChart.Series series = new XYChart.Series();
        a = Double.parseDouble(firstNumber.getText());
        b = Double.parseDouble(secondNumber.getText());
        c = Double.parseDouble(lastNumber.getText());
        calculate(a,b,c);
        series.getData().clear();

        for(float i=Math.round(x1)-3; i <= Math.round(x2)+3; i+=0.1){
            series.getData().add(new XYChart.Data(i, a*i*i+b*i+c));

          }
        lineChart.getData().add(series);
    }

    public void calculate(double a, double b, double c){
        double delta;
        delta = b*b-4*a*c;
        if(delta > 0) {
            x1 = (-b - Math.sqrt(delta)) / (2 * a);
            x2 = (-b + Math.sqrt(delta)) / (2 * a);

            wynikLabel.setText("Wynik: x1:" + x1 + ", x2:" + x2);
        }
        else
            wynikLabel.setText("Nie ma rozwiazan rzeczywistych");
    }
}
