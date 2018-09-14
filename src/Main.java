import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите программу для запуска: \n 1 - Калькулятор \n 2 - Максимальный элемент в массиве");
        boolean check = false;

        while (!check) {
            String program = reader.readLine();
            if (program.equals("1")) {
                check = true;
                Calculator calculator = new Calculator();
                calculator.startCalculator();
            } else if (program.equals("2")) {
                check = true;
                MaxElement maxElement = new MaxElement();
                maxElement.startMaxElement();
            } else System.err.println("Введено неверное значение. \nВведите \"1\" для запуска Калькулятора\nВведите \"2\" для запуска Поиска слова максимальной длины в списке");
        }
    }
}
