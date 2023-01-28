package ru.job4j.template;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.*;

class GoGenerateTest {

    @Ignore
    @Test
    public void whenArgumentsIsInvalid() {
        GoGenerate goGenerate = new GoGenerate();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "Who");
        assertThatThrownBy(() -> goGenerate.produce(null, args)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Ignore
    @Test
    public void whenKeyIsInvalid() {
        GoGenerate goGenerate = new GoGenerate();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "Who");
        goGenerate.produce("I am a ${name}, Who are ${subject}? ", args);
        assertThatThrownBy(() -> args.get("Sergei")).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Ignore
    @Test
    public void whenValueIsInvalid() {
        GoGenerate goGenerate = new GoGenerate();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "Who");
        args.put("family", "Ivanov");
        goGenerate.produce("I am a ${name}, Who are ${subject}? ", args);
        assertThatThrownBy(() -> args.get("family")).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Ignore
    @Test
    public void whenCorrectTest() {
        GoGenerate goGenerate = new GoGenerate();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "Who");
        assertThat(goGenerate.produce("I am a ${name}, Who are ${subject}? ", args))
                .isEqualTo("I am a Petr, Who are When? ");
    }
}