package counttreemap;

import java.util.Map;
import java.util.TreeMap;

public class treemap {
    public static void countWords(String text) {
        // Loại bỏ khoảng trắng và dấu câu từ văn bản
        String cleanedText = text.replaceAll("[^a-zA-Z ]", "");

        // Chuyển đổi thành chữ thường và tách thành các từ
        String[] words = cleanedText.toLowerCase().split("\\s+");

        // Tạo một TreeMap để lưu trữ các từ và số lần xuất hiện của chúng theo thứ tự chữ cái
        Map<String, Integer> wordCountMap = new TreeMap<>();

        // Đếm số lần xuất hiện của từng từ
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Hiển thị từ và số lần xuất hiện của chúng theo thứ tự chữ cái
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        String text = "This is a sample text. It contains some sample words.";
        countWords(text);
    }
    }

