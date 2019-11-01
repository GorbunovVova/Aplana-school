package tack2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Task2Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Введите путь до файла");
        Scanner input = new Scanner(System.in);
        File file = new File(input.nextLine().trim());
        input = new Scanner(file);
        //Scanner input = new Scanner(new File("input.txt"));
        Map<String, Integer> words = new TreeMap<>();
        while (input.hasNext()) {
            String word = input.next().replaceAll("\\pP", "");
            Integer count = words.get(word);
            if (count == null) {
                count = 0;
            }
            words.put(word, ++count);
        }
        int maxFrequency = 0;
        String maxFrequencyWord = "";
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            if (entry.getValue() > maxFrequency) {
                maxFrequency = entry.getValue();
                maxFrequencyWord = entry.getKey();
            }
        }
        System.out.println("Наиболее употребляемое слово - " + maxFrequencyWord + " - " + maxFrequency);
    }
}
