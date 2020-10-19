package ru.ancndz.javaSchool;

import java.util.Arrays;
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
        Arrays.stream(clearText).forEach(word -> result.put(word, result.getOrDefault(word, 0) + 1));
        return result;
    }
}