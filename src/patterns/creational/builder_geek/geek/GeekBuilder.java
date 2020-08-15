package patterns.creational.builder_geek.geek;

import java.util.List;

/**
 * Builder interface describe step of object creation.
 **/
public interface GeekBuilder {

    void setType(String type);

    void setLanguages(List<String> languages);

    void setExperience(int experience);

}
