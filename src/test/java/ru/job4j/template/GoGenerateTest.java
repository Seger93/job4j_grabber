package ru.job4j.template;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.assertj.core.api.Assertions.*;
@Disabled
class GoGenerateTest {
    @Test
    public void whenArgumentsIsInvalid() {
        GoGenerate goGenerate = new GoGenerate();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "Who");
        assertThatThrownBy(() -> goGenerate.produce(null, args)).
                isInstanceOf(IllegalArgumentException.class);
    }

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

    @Test
    public void whenCorrectTest() {
        GoGenerate goGenerate = new GoGenerate();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "Who");
        assertThat(goGenerate.produce("I am a ${name}, Who are ${subject}? ", args))
                .isEqualTo("I am a Petr, Who are When? ");
    }

    @Test
    public void whenInCorrectTest() {
        GoGenerate goGenerate = new GoGenerate();
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr");
        args.put("subject", "Who");
        goGenerate.produce("I am a ${name}, Who are ${subject}? ", args);
        assertThat(goGenerate.produce("I am a ${name}, Who are ${subject}? ", args))
                .isNotEqualTo("I am a Petr, Who are When? ");
    }
}