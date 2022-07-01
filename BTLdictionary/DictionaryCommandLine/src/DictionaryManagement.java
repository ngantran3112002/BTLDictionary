package CommandLine;

import java.io.*;
import java.util.Objects;
import java.util.Scanner;
import java.lang.String;
import java.util.TreeMap;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DictionaryManagement {
    //    public static int temp = 0;
    // tạo một cái dictionary mới
   // public static Dictionary dict = new Dictionary();
    private static int size;

    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    public static Explain MeaningAndExample = new Explain("", "","","");
    public static TreeMap<String, Explain> ListOfWords = new TreeMap<>();
    // them tu
    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        for(int i = 0; i < size; i++) {
            String temp1 = sc.nextLine();
            String temp2 = sc.nextLine();
            String temp3 = sc.nextLine();
            String temp4 = sc.nextLine();
            String temp5 = sc.nextLine();
            ListOfWords.put(temp1, new Explain(temp2, temp3, temp4, temp5));
        }
        sc.close();
    }

    // print tu
    //set<String> lis = new
    public  static void showAllWords() {
        System.out.println("No\t| English\t\t| Vietnamese\t");
        int i = 1;
        for (String key : ListOfWords.keySet()) {
            System.out.println(i++ + "\t" + "|" + key + "\t\t" + "|" + ListOfWords.get(key).getMeaning());
           // System.out.println(key);
        }
    }

    // nhap du lieu tu dien tu tep dictionaries.txt
    public static void insertFromFile() throws IOException {
        File file = new File("C:\\Users\\Admin\\Downloads\\Dictionaries.txt");
        Scanner sc = new Scanner(file);
        String[] results;
        while(sc.hasNextLine()){
            results = sc.nextLine().split("\t");
            ListOfWords.put(results[0],new Explain(results[1], results[2], results[3],results[4]));
        }
        sc.close();
    }

    // tìm từ có trong từ điển không. nếu có in ra nghĩa. k có in null
    public static String dictionaryLookup(String findWord) {

        // duyệt từ key đầu đến cuối trong ListOfWords
        //for (String key : ListOfWords.keySet()) {
            if (ListOfWords.get(findWord) != null) {
                String results = ListOfWords.get(findWord).getMeaning() + "\n";
                results += (ListOfWords.get(findWord).getExample() + "\n");
                results += (ListOfWords.get(findWord).getSynonym() + "\n");
                results += (ListOfWords.get(findWord).getAntonym() + "\n");
                return results;
            }
       // }
        return null;
    }

    // tìm từ có trong từ điển không bằng đầu bằng vài chữ.
    public static void dictionarySearcher(String word) {
        int n = word.length();
        int count = 0;
        for (String key : ListOfWords.keySet()){
            String ss = key.substring(0, n);
            if (Objects.equals(ss, word)) {
                count++;
                System.out.println(key);
                System.out.println(ListOfWords.get(ListOfWords.firstKey()).getMeaning());
                System.out.println(ListOfWords.get(ListOfWords.firstKey()).getExample());
                System.out.println(ListOfWords.get(ListOfWords.firstKey()).getSynonym());
                System.out.println(ListOfWords.get(ListOfWords.firstKey()).getAntonym());

            }
        }
        if(count == 0) {
            System.out.print("NOT FOUND");
        }
    }

    // xuất từ điển ra file
    public static void dictionaryExportToFile() {
        int sizeOfArr = ListOfWords.size();
        try {
            FileWriter fw = new FileWriter("C:\\Users\\Admin\\Downloads\\Dictionaries.txt");
            BufferedWriter bw = new BufferedWriter (fw);
            for (Map.Entry<String, Explain> entry : ListOfWords.entrySet()) {
                String s = entry.getKey() + "\t" + entry.getValue().getMeaning() + "\t" + entry.getValue().getExample()+ "\t" + entry.getValue().getSynonym()+ "\t" + entry.getValue().getAntonym();
                bw.write(s);
                bw.newLine();
            }
            bw.close();
            fw.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static void main(String[] args) {
        DictionaryManagement example = new DictionaryManagement();
        try {
            example.insertFromFile();
            System.out.print(example.dictionaryLookup("happy"));
            //example.dictionarySearcher("a");
            //example.dictionarySearcher("j");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
