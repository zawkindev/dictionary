package zawkin.asuna.model;

public class WordModel {
    private String name;
    private String translation;


    public WordModel(String name, String translation) {
        this.name = name;
        this.translation = translation;
    }

    public String convertToCSV() {
        return this.name + "," + this.translation + "\n";
    }
}
