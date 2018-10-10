import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class TestClass {

  public static void main(String[] args) throws IOException {
    File file = new File("new1.txt");
    Pattern pattern = Pattern.compile("\\p{Punct}|\\s");

    TreeMap<String, Integer> map = new TreeMap<>();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] split = pattern.split(line.toLowerCase());
        for (String s : split) {
          if (!s.equals("")) {
            if (map.containsKey(s)) {
              map.replace(s, map.get(s) + 1);
            } else {
              map.put(s, 1);
            }
          }
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("The pathfile is not found");
    }
    ArrayList<WordCount> list = new ArrayList<>();
    for (Map.Entry<String, Integer> pair : map.entrySet()) {
      WordCount wordCount = new WordCount(pair.getValue(), pair.getKey());
      list.add(wordCount);
    }
    list.sort(new Comparator<WordCount>() {
      @Override
      public int compare(WordCount o1, WordCount o2) {
        return Integer.compare(o1.count, o2.count);
      }});
    int sizeTop = 5;
    for (int i = list.size()-1; i > list.size()-(sizeTop+1); i--) {
      WordCount wordCount = list.get(i);
      System.out.println(wordCount);
    }
  }
}
