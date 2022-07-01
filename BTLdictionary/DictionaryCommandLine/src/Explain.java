package CommandLine;

public class Explain {
    private String Meaning;
    private String Example;
    private String Synonym;
    private String Antonym;


    // init Meaning
    public Explain(String Meaning, String Example, String Synonym, String Antonym) {
        this.Meaning = Meaning;
        this.Example = Example;
        this.Synonym = Synonym;
        this.Antonym = Antonym;
    }

    public String getExample() {
        return Example;
    }

    public String getMeaning() {
        return Meaning;
    }

    public void setExample(String example) {
        Example = example;
    }

    public void setMeaning(String meaning) {
        Meaning = meaning;
    }

    public void setAntonym(String Antonym) {
        this.Antonym = Antonym;
    }

    public void setSynonym(String Synonym) {
        this.Synonym = Synonym;
    }

    public String getSynonym() {
        return Synonym;
    }

    public String getAntonym() {
        return Antonym;
    }

}
