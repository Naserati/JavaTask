import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Выберите программу для запуска: \n 1 - Калькулятор \n 2 - Максимальный элемент в массиве");
        int program = Integer.parseInt(reader.readLine());
        if (program == 1) {
            Calculator calculator = new Calculator();
            calculator.startCalculator();
        }
        else if (program == 2) {
            MaxElement maxElement = new MaxElement();
            maxElement.startMaxElement();
        }
        else System.out.println("Введено неверное значение");
    }
}
