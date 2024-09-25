package zawkin.asuna.model;


public class WordModel {
    private int id;
    private String eng;
    private String uzb;

    public void setId(int id) {
        this.id = id;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public void setUzb(String uzb) {
        this.uzb = uzb;
    }

    public int getId() {
        return id;
    }

    public String getEng() {
        return eng;
    }

    public String getUzb() {
        return uzb;
    }

    public String convertToCSV() {
        return this.eng + "," + this.uzb + "\n";
    }
}
