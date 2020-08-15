package patterns.creational.builder_geek.geek;

import java.util.List;

/**
 * Concrete Builder build Geek component.
 **/
public class GeekBuilderImpl implements GeekBuilder {
    private String type;
    private List<String> languages;
    private int experience;

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Geek getResult() {
        return new Geek(type, languages, experience);
    }
}
