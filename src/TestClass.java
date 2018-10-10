import java.io.*;
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
        System.out.println("line = " + line);
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
//    printMap(map);
    TreeMap<Integer, String> mapTemp = new TreeMap<>();
    for (Map.Entry<String, Integer> pair : map.entrySet()) {
      String key = pair.getKey();
      Integer value = pair.getValue();
      mapTemp.put(value, key);
    }
    for (Map.Entry<Integer, String> pair : mapTemp.entrySet()) {
      Integer key = pair.getKey();
      String value = pair.getValue();
      System.out.println(key + " " + value);
    }
  }

  private static void printMap(TreeMap<String, Integer> everyMap) {
    System.out.println("The five most common words:");
    for (Map.Entry<String, Integer> pair : everyMap.entrySet()) {
      String key = pair.getKey();
      Integer value = pair.getValue();
      System.out.println(key + " has been found " + value + "times");
    }
  }
}
