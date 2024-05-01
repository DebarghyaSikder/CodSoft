// TASK 2

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordCounter {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter text or provide a file path to count the words: ");
        String input = scanner.nextLine();


        String text = "";
        if (input.startsWith("file:")) {
            String filePath = input.substring(5);
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                text = sb.toString();
            } catch (IOException e) {
                System.err.println("Error reading file: " + e.getMessage());
                return;
            }
        } else {
            text = input;
        }


        String[] words = text.split("[\\s\\p{Punct}]+");


        int wordCount = 0;


        Set<String> stopWords = new HashSet<>();
        stopWords.add("the");
        stopWords.add("and");



        Map<String, Integer> wordFrequencies = new HashMap<>();


        for (String word : words) {

            if (!stopWords.contains(word.toLowerCase())) {

                wordCount++;


                wordFrequencies.put(word.toLowerCase(), wordFrequencies.getOrDefault(word.toLowerCase(), 0) + 1);
            }
        }


        System.out.println("Total number of words: " + wordCount);


        System.out.println("Number of unique words: " + wordFrequencies.size());


        System.out.println("Word frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        scanner.close();
    }
}

