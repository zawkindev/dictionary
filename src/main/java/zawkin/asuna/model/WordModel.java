package zawkin.asuna.model;

public class WordModel {
    private String name;
    private String translation;

    public WordModel() {
        this.name = "";
        this.translation = "";
    }

    public WordModel(String name, String translation) {
        this.name = name;
        this.translation = translation;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String convertToCSV() {
        return this.name + "," + this.translation + "\n";
    }
}
