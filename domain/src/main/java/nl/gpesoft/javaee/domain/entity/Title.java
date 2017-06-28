package nl.gpesoft.javaee.domain.entity;

public enum Title {
    DR("Dr"),
    DRS("Drs"),
    MSC("Ir"),
    BSC("Ing");

    private String title;

    Title(String title) {
        this.title = title;
    }

    public String title() {
        return title;
    }
}