package ru.ancndz.javaSchool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

class CounterTest {

    private String testText;

    @BeforeEach
    void setTestText() {
        this.testText = "      Привет текст    ! Я простой текст,а ты не простой. Привет Я несу много смысла?привет еще раз.";
    }

    @Test
    void everyWordCount() {
        Counter counter = new Counter(this.testText);

        Map<String, Integer> mapWithResult = counter.everyWordCount();

        //Проверка, что нужные символы удалены
        Assertions.assertFalse(mapWithResult.containsKey("!"));
        Assertions.assertFalse(mapWithResult.containsKey("    "));
        Assertions.assertFalse(mapWithResult.containsKey(" "));

        //Проверка кол-ва вхождений опредленного слова
        Assertions.assertEquals(mapWithResult.get("текст"), 2);
        Assertions.assertEquals(mapWithResult.get("ты"), 1);
        Assertions.assertEquals(mapWithResult.get("Привет"), 2);

    }
}