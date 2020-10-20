package ru.ancndz.javaSchool.firstTask;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.ancndz.javaSchool.firstTask.Counter;

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
        Assertions.assertEquals(2, mapWithResult.get("текст"));
        Assertions.assertEquals(1, mapWithResult.get("ты"));
        Assertions.assertEquals(2, mapWithResult.get("Привет"));
        Assertions.assertEquals(1, mapWithResult.get("привет"));

    }
}