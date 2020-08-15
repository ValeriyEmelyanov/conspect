package patterns.creational.builder_geek.geek;

import java.util.ArrayList;

/**
 * Builder Director.
 */
public class GeekDirector {
    public void buildAdmin(GeekBuilder builder) {
        builder.setType("Admin");
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Perl");
        languages.add("PowerShell");
        builder.setLanguages(languages);
        builder.setExperience(10);
    }

    public void buildBackend(GeekBuilder builder) {
        builder.setType("Backend");
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Python");
        languages.add("PHP");
        builder.setLanguages(languages);
        builder.setExperience(5);
    }

    public void buildRockstar(GeekBuilder builder) {
        builder.setType("Rockstar");
        ArrayList<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Kotlin");
        languages.add("Scala");
        languages.add("Angular");
        builder.setLanguages(languages);
        builder.setExperience(20);
    }
}
