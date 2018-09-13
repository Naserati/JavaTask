import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MaxElement {
    /**
     * Метод для запуска программы "Поиск слова с максимальной длиной"
     */
    public void startMaxElement() throws IOException {
        ArrayList<String> listOfElements = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество слов в массиве");
        int countOfWords = Integer.parseInt(reader.readLine());

        //Вводим слова и добавляем их в список
        for (int i = 0; i < countOfWords; i++) {
            System.out.println(String.format("Введите слово №%d", i + 1));
            String word = reader.readLine();
            listOfElements.add(word);
        }

        //Вычисляем максимальное количество символов одного слова в списке
        int max = 0;
        for (int i = 0; i < listOfElements.size(); i++) {
            if (listOfElements.get(i).length() >= max) {
                max = listOfElements.get(i).length();
            }
        }

        /*
        Выводим слово максимальной длины в консоль.
        Если есть несколько слов равной максимальной длины,
        то выводим все эти слова.
         */

        ArrayList<String> resultList = new ArrayList<>();
        System.out.println("Самое длинное слово в массиве:");

        for (int i = 0; i < listOfElements.size(); i++) {
            if (listOfElements.get(i).length() == max) {
                System.out.println(String.format("%s (количество букв - %d)", listOfElements.get(i), max));
            }
        }
    }
}
