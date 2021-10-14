package core;

import language.impl.Languages;

public class Settings {

    Languages language = Languages.ENGLISH;


    public void setEnglishLanguage() {
        language = Languages.ENGLISH;
    }

    public void setSlovakLanguage() {
        language = Languages.SLOVAK;
    }

    public Languages getLanguage() {
        return language;
    }
}
