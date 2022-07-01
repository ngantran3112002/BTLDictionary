import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        DictionaryManagement example = new DictionaryManagement();
        try {
            example.insertFromFile();
            example.showAllWords();
//            System.out.print(example.dictionaryLookup("cammm"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}