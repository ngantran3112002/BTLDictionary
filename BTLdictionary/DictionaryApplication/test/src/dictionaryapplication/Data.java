/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dictionaryapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author HH
 */
public class Data {
  public static TreeMap<String, String> ListOfWords = new TreeMap<>();
    public static Set<String> SetOfWordTarget = ListOfWords.keySet();
    public static String path = "Dic.txt";
    public static File file = new File(path);
    
    /**
     * lấy dữ liệu từ file Dictionaries.txt.
     * @throws IOException 
     */
    public static void insertfromfile() throws IOException {
        try (
            FileReader fr = new FileReader(path)) {
            BufferedReader br = new BufferedReader(fr);
            String[] results;
            
            String line;
            while ((line = br.readLine()) != null) {
                 results = line.split("#");
                String explain = line.substring( results[0].length() + 1, line.length());
                if (explain.equals("*delete")) {
                    ListOfWords.remove(results[0]);
                } else {
                    ListOfWords.put(results[0], explain);
                }
            }
            br.close();
            fr.close();
        }
    }
    
    public static void dictionaryExportToFile() {
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for (String word : SetOfWordTarget) {
                String re = ListOfWords.get(word);
                String s = word + "#" + re;
                bw.write(s);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static void addNewWordToFile(String newWord, String explain) throws IOException {
        String x = "\n" + newWord + "#" + explain.replace('\n', '|');
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.append(x);
            fw.close();
        }
    }
    
//       public static void addNewWordToFile2(String newWord, String explain) throws IOException {
//        String x = "\n" + newWord + "#" + explain.replace('\n', '|');
//        try (FileWriter fw = new FileWriter(file, true)) {
//            fw.append(x);
//            fw.close();
//        }
//    }
//        private void txtthemActionPerformed(java.awt.event.ActionEvent evt) {                                        
//        // TODO add your handling code here:
//         String wordTarget = txttumoi.getText();
//        String meaning = txtnghia.getText();
//        if (checkNewWord(wordTarget, meaning)) {
//            // cập nhật treemap
//            meaning.replace("\n", "|\n");
//            meaning = meaning.substring(0, meaning.length()-2);
//            meaning = "$" + meaning;
//            Data.ListOfWords.put(wordTarget, new Expain(meaning));
//            meaning = meaning.replace("\n", "-");
//            // cập nhật lại JList
//            DictionaryApplication.setListModel();
//            String word = wordTarget + meaning;
//             try {
//                 Data.addNewWordToFile(word);
//             } catch (IOException ex) {
//                 Logger.getLogger(addWordJFrame.class.getName()).log(Level.SEVERE, null, ex);
//             }
//            
//        }      
//    }
    
    
    public Data() {
    }
    
}
