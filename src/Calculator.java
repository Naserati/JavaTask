import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {
    /**
     * Метод для запуска программы "Калькулятор"
     */
    public void startCalculator() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выражение из 2х чисел: ");
        String expression = reader.readLine();
        /*
        Проверяем, если выражение написано слитно, то разделяем числа от знака пробелом.
         */
        if (expression.contains("+")) expression = expression.replace("+", " + ");
        else if (expression.contains("-")) expression = expression.replace("-", " - ");
        else if (expression.contains("*")) expression = expression.replace("*", " * ");
        else if (expression.contains("/")) expression = expression.replace("/", " / ");

        if (expression.contains(",")) expression = expression.replace(",", ".");

        String finalExpression[] = expression.split(" ");

        String sign = finalExpression[1];

        System.out.print("Результат: ");
        if (sign.equals("+")) {
            double result = Double.parseDouble(finalExpression[0]) + Double.parseDouble(finalExpression[2]);
            System.out.printf("%.3f", result);
        } else if (sign.equals("-")) {
            double result = Double.parseDouble(finalExpression[0]) - Double.parseDouble(finalExpression[2]);
            System.out.printf("%.3f", result);
        } else if (sign.equals("*")) {
            double result = Double.parseDouble(finalExpression[0]) * Double.parseDouble(finalExpression[2]);
            System.out.printf("%.3f", result);
        } else if (sign.equals("/")) {
            double result = Double.parseDouble(finalExpression[0]) / Double.parseDouble(finalExpression[2]);
            System.out.printf("%.3f", result);
        }
    }
}