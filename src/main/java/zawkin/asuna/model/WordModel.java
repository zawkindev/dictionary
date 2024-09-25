package zawkin.asuna.model;

public class WordModel {
    private int id;
    private String name;
    private String translation;

    public WordModel(String name, String translation) {
        this.name = name;
        this.translation = translation;
    }

    public WordModel(int id, String name, String translation) {
        this.id = id;
        this.name = name;
        this.translation = translation;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTranslation() {
        return translation;
    }

    public String convertToCSV() {
        return this.name + "," + this.translation + "\n";
    }
}
