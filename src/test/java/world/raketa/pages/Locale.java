package world.raketa.pages;

public enum Locale {
    EN("en"),
    RU("ru");

    private final String language;

    Locale(String locale) {
        this.language = locale;
    }

    public String getLanguage() {
        return language;
    }
}
