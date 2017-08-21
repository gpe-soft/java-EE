package nl.gpesoft.javaee.domain.entity;

import java.util.HashMap;
import java.util.Map;

public enum Title {
    DR("Dr"),
    DRS("Drs"),
    MSC("Ir"),
    BSC("Ing");

    private String title;

    private static final Map<String, Title> map = new HashMap<>(values().length, 1);

    static {
        for (Title c : values()) {
            map.put(c.title, c);
        }
    }

    Title(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }

    public static Title of(String name) {
        Title result = map.get(name);
        if (result == null) {
            throw new IllegalArgumentException("Invalid title name: " + name);
        }
        return result;
    }
}