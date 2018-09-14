import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Calculator {
    /**
     * Метод для запуска программы "Калькулятор"
     */
    public void startCalculator() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выражение из 2х чисел: ");
        String expression = reader.readLine();

        calculate(expression);

    }

    public void calculate(String expression) {
        ArrayList<String> list = new ArrayList<>();

        //Проверяем, если выражение написано слитно, то разделяем числа от знака пробелом.
        if (expression.contains("+")) expression = expression.replace("+", " + ");
        if (expression.contains("-")) expression = expression.replace("-", " - ");
        if (expression.contains("*")) expression = expression.replace("*", " * ");
        if (expression.contains("/")) expression = expression.replace("/", " / ");

        //Замена запятой на точку, если таковая есть в выражении
        if (expression.contains(",")) expression = expression.replace(",", ".");

        //Разбиваем выражение на числа и знаки
        String finalExpression[] = expression.split(" ");
        for (String element : finalExpression) {
            list.add(element);
        }

        System.out.print("Результат: ");
        double result = 0;

        while (true) {
            if (list.contains("*") || list.contains("/")) {
                for (int i = 0; i < list.size(); i++) {

                    if (list.get(i).equals("*")) {
                        result = Double.parseDouble(list.get(i - 1)) * Double.parseDouble(list.get(i + 1));
                        list.remove(i + 1);
                        list.remove(i);
                        list.remove(i - 1);
                        list.add(i - 1, String.valueOf(result));
                        break;
                    }
                    if (list.get(i).equals("/")) {
                        result = Double.parseDouble(list.get(i - 1)) / Double.parseDouble(list.get(i + 1));
                        list.remove(i + 1);
                        list.remove(i);
                        list.remove(i - 1);
                        list.add(i - 1, String.valueOf(result));
                        break;
                    }
                }
            } else break;
        }
        while (true) {
            if (list.contains("+") || list.contains("-")) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals("+")) {
                        result = Double.parseDouble(list.get(i - 1)) + Double.parseDouble(list.get(i + 1));
                        list.remove(i + 1);
                        list.remove(i);
                        list.remove(i - 1);
                        list.add(i - 1, String.valueOf(result));
                    }
                    if (list.get(i).equals("-")) {
                        result = Double.parseDouble(list.get(i - 1)) - Double.parseDouble(list.get(i + 1));
                        list.remove(i + 1);
                        list.remove(i);
                        list.remove(i - 1);
                        list.add(i - 1, String.valueOf(result));
                    }
                }
            } else break;
        }
        System.out.printf("%.3f", result);
    }
}