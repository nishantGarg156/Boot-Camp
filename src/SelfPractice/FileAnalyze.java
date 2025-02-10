package SelfPractice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
public class FileAnalyze {
    private String fileContent;
    private Map<String, Integer> wordFrequency;
    public FileAnalyze(String filePath) throws FileNotFoundException {
        readFile(filePath);
        calculateWordFrequency();
    }
    private void calculateWordFrequency() {
        wordFrequency = new HashMap<>();
        String[] words = fileContent.split("\n");
        for (String word : words) {
        word = word.toLowerCase().replaceAll("[^a-zA-Z]]", "");
        wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
        }

    }

    private void readFile(String filePath) throws FileNotFoundException {
      StringBuilder Content = new StringBuilder();
      try{
          BufferedReader br = new BufferedReader(new FileReader(filePath));
          String line;
          while((line = br.readLine())!=null){
            Content.append(line).append("\n");
          }
       }catch(Exception e){
          e.printStackTrace();
      }
      fileContent = Content.toString().trim();
    }

    public String ConvertToUpperCase() {
        return fileContent.toUpperCase();
    }
    public String ConvertToLowerCase() {
        return fileContent.toLowerCase();
    }

}
