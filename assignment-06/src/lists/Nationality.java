package lists;

import java.text.Collator;
import java.util.Locale;
import java.util.Random;

public enum Nationality {
    Belarussian(new Locale("by")),
    British(new Locale("en_UK")),
    Chinese(new Locale("zh")),
    Indian(new Locale("hi")),
    Latvian(new Locale("lv")),
    Lithuanian(new Locale("lt")),
    Polish(new Locale("pl")),
    Slovak(new Locale("sk")),
    Ukrainian(new Locale("uk")),
    Vietnamese(new Locale("vi"));

    private Collator collator;
    private Locale locale;

    Nationality(Locale locale){
        this.locale = locale;
        this.collator = Collator.getInstance(locale);

    }

    public Collator getCollator() {
        return collator;
    }

    public Locale getLocale() {
        return locale;
    }

    private static Random randomizer = new Random();


    public static Nationality random() {
        Nationality[] natinalities = Nationality.values();
        int x = randomizer.nextInt(natinalities.length);
        return natinalities[x];
    }
}
