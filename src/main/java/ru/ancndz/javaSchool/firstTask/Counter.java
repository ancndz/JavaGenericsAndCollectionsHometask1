package ru.ancndz.javaSchool.firstTask;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class Counter {
    private final String text;

    public Counter(String text) {
        this.text = text;
    }

    /**
     * Подсчет слов в строке
     * @return Map<Слово, Число>
     */
    public Map<String, Integer> everyWordCount() {
        Pattern punctuations = Pattern.compile("[\\s,.!?]+");
        String[] clearText = punctuations.split(this.text);
        Map<String, Integer> result = new HashMap<>();

        for (String word: clearText) {
            result.put(word, result.getOrDefault(word, 0) + 1);
        }

        return result;
    }
}
