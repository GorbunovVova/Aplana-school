package tack2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Task2Main {
    private static Scanner input;

    private static void readFile() {
        System.out.println("Введите путь до файла");
        input = new Scanner(System.in);
        File file = new File(input.nextLine().trim());
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Путь указан не верно");
            readFile();
        }
    }

    public static void main(String[] args) {
        readFile();
        //Scanner input = new Scanner(new File("input.txt"));
        Map<String, Integer> words = new TreeMap<>();
        int maxFrequency = 0;
        while (input.hasNext()) {
            String word = input.next().replaceAll("\\pP", "");
            Integer count = words.get(word);
            if (count == null) {
                count = 0;
            }
            words.put(word, ++count);
            if (count > maxFrequency) {
                maxFrequency = count;
            }
        }
        List<String> maxFrequencyWords = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            if (entry.getValue() == maxFrequency) {
                maxFrequencyWords.add(entry.getKey());
            }
        }
        System.out.println("Самые часто употребляемые слова: " + maxFrequencyWords + " - " + maxFrequency);
    }
}
