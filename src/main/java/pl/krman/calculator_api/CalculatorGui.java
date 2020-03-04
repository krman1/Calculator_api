package pl.krman.calculator_api;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;


@Route("calculator")
public class CalculatorGui extends VerticalLayout {

    @Autowired
    Calculator calculator;

    public CalculatorGui() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        NumberField numberFieldFirstNumber = new NumberField("Podaj pierwszą liczbę");
        numberFieldFirstNumber.setSizeFull();
        NumberField numberFieldSecondNumber = new NumberField("Podaj drugą liczbę");
        numberFieldSecondNumber.setSizeFull();
        Button buttonAdd = new Button("Dodawanie");
        Button buttonSubtract = new Button("Odejmowanie");
        Button buttonMultiply = new Button("Mnożenie");
        Button buttonDivide = new Button("Dzielenie");
        Label labelScore = new Label("Wynik");


        buttonAdd.addClickListener(event -> {
            labelScore.setText("Wynikiem dodawania jest = " + calculator.add(numberFieldFirstNumber.getValue(),numberFieldSecondNumber.getValue()));
        });

        buttonSubtract.addClickListener(event -> {
            labelScore.setText("Wynikiem odejmowania jest = " + calculator.subtract(numberFieldFirstNumber.getValue(),numberFieldSecondNumber.getValue()));
        });

        buttonMultiply.addClickListener(event -> {
            labelScore.setText("Wynikiem mnożenia jest = " + calculator.multiply(numberFieldFirstNumber.getValue(),numberFieldSecondNumber.getValue()));
        });

        buttonDivide.addClickListener(event -> {
            try{
                labelScore.setText("Wynikiem dzielenia jest = " + calculator.divide(numberFieldFirstNumber.getValue(), numberFieldSecondNumber.getValue())); }
            catch (ArithmeticException e){
                labelScore.setText("Cannot be divided by zero");
            }
        });

        horizontalLayout.add(buttonAdd,buttonSubtract,buttonMultiply,buttonDivide);
        add(numberFieldFirstNumber,numberFieldSecondNumber);
        add(horizontalLayout);
        add(labelScore);
    }
}
