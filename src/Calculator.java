import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Calculator {

    private double result = 0;

    /**
     * Метод для запуска программы "Калькулятор"
     */
    public void startCalculator() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите выражение: ");
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
        if (expression.contains("(")) expression = expression.replace("(", " ( ");
        if (expression.contains(")")) expression = expression.replace(")", " ) ");

        //Замена запятой на точку, если таковая есть в выражении
        if (expression.contains(",")) expression = expression.replace(",", ".");

        //Разбиваем выражение на числа и знаки
        String finalExpression[] = expression.split(" ");
        for (String element : finalExpression) {
            if(!element.equals("")) list.add(element);
        }

        System.out.print("Результат: ");
        ArrayList<String> secondExpression = new ArrayList<>();

        while (true) {
            int startPoint = 0;
            int endPoint = 0;
            if (list.contains("(")) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals("(")) {
                        startPoint = i;
                        //Записываем в вспомогательный список выражение в скобках
                        for (int j = i + 1; j < list.size(); j++) {
                            if (!list.get(j).equals(")")) {
                                secondExpression.add(list.get(j));
                            } else if (list.get(j).equals(")")) {
                                endPoint = j;
                                operations(secondExpression);
                                break;
                            }
                        }
                        //Удаляем из списка выражение в скобках
                        for (int k = endPoint; k < list.size(); k--) {
                            if (k >= startPoint) {
                                list.remove(k);
                                if (k == startPoint) break;
                            }
                        }
                        //Добавляем в скобки результат вычисления
                        list.add(i, String.valueOf(result));
                        if(i != 0) {
                            if(!list.get(i-1).equals("+") && !list.get(i-1).equals("-") && !list.get(i-1).equals("*") && !list.get(i-1).equals("/"))
                                list.add(i, "*");
                        }
                    }
                }
                operations(list);
            }
            else {
                operations(list);
            }
           break;
        }

        System.out.printf("%.3f", result);
        System.out.println();
    }

    public void operations(ArrayList<String> list) {
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
                        break;
                    }
                    if (list.get(i).equals("-")) {
                        result = Double.parseDouble(list.get(i - 1)) - Double.parseDouble(list.get(i + 1));
                        list.remove(i + 1);
                        list.remove(i);
                        list.remove(i - 1);
                        list.add(i - 1, String.valueOf(result));
                        break;
                    }
                }
            } else break;
        }
    }
}