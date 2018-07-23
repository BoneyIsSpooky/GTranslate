package de.boney.gtranslate;

import java.util.Optional;

public class Languages {

    public static Optional<Language> getLanguageByCode(String code) {
        for (Language l : Language.values()) if (l.code.equalsIgnoreCase(code)) return Optional.of(l);
        return Optional.empty();
    }

    public static Optional<Language> getLanguageByName(String name) {
        for (Language l : Language.values()) if (l.name.equalsIgnoreCase(name)) return Optional.of(l);
        return Optional.empty();
    }
}
