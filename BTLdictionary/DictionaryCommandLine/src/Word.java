package CommandLine;

public class Word {
    private String WordTarget;
    private String WordExplain;


    // setter, getter Word
    public String getWordTarget() {
        return WordTarget;
    }

    public String getWordExplain() {
        return WordExplain;
    }

    public void setWordExplain(String WordExplain) {
        this.WordExplain = WordExplain;
    }

    public void setWordTarget(String WordTarget) {
        this.WordTarget = WordTarget;
    }


    Word() {
        this.WordTarget = "";
        this.WordExplain = "";
    }
}
