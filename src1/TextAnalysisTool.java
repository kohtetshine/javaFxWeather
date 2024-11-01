import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextAnalysisTool {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: User Input
        System.out.println("Please enter a paragraph or lengthy text:");
        String text = scanner.nextLine();

        // Step 2: Character and Word Count
        int charCount = text.length();
        String[] words = text.split("\\s+");
        int wordCount = words.length;
        System.out.println("Total number of characters: " + charCount);
        System.out.println("Total number of words: " + wordCount);

        // Step 3: Most Common Character
        char mostCommonChar = findMostCommonCharacter(text);
        System.out.println("Most common character: " + mostCommonChar);

        // Step 4: Character Frequency
        System.out.println("Enter a character to find its frequency:");
        char character = scanner.nextLine().toLowerCase().charAt(0);
        int charFrequency = countCharacterFrequency(text, character);
        System.out.println("Frequency of character '" + character + "': " + charFrequency);

        // Step 5: Word Frequency
        System.out.println("Enter a word to find its frequency:");
        String word = scanner.nextLine().toLowerCase();
        int wordFrequency = countWordFrequency(text, word);
        System.out.println("Frequency of word '" + word + "': " + wordFrequency);

        // Step 6: Unique Words
        int uniqueWordsCount = countUniqueWords(words);
        System.out.println("Number of unique words: " + uniqueWordsCount);

        scanner.close();
    }

    private static char findMostCommonCharacter(String text) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char ch : text.toLowerCase().toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
        }
        return charCountMap.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse('?');
    }

    private static int countCharacterFrequency(String text, char character) {
        int count = 0;
        for (char ch : text.toLowerCase().toCharArray()) {
            if (ch == character) {
                count++;
            }
        }
        return count;
    }

    private static int countWordFrequency(String text, String word) {
        int count = 0;
        for (String w : text.toLowerCase().split("\\s+")) {
            if (w.equals(word)) {
                count++;
            }
        }
        return count;
    }

    private static int countUniqueWords(String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            String lowerCaseWord = word.toLowerCase();
            wordMap.put(lowerCaseWord, wordMap.getOrDefault(lowerCaseWord, 0) + 1);
        }
        return wordMap.size();
    }
}
