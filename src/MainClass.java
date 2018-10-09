import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class MainClass {
  public static void main(String[] args) throws IOException {

    File file = new File("new1.txt");
    TreeMap<String, Integer> map = new TreeMap<>();
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] array = line.toLowerCase().split("\\p{Punct}|\\s");
        for (int i = 0; i < array.length; i++) {
          if (map.containsKey(array[i])) {
            map.replace(array[i], map.get(array[i]) + 1);
          } else {
            map.put(array[i], 1);
          }
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("The pathfile is not found");
    }
    printMap(map);
  }

//  private static void times(int x) {
//    if
//  }
  private static void printMap(TreeMap<String, Integer> everyMap) {
    System.out.println("The five most common words:");
    for (Map.Entry<String, Integer> pair : everyMap.entrySet()) {
      String key = pair.getKey();
      Integer value = pair.getValue();
      System.out.println(key + " has been found " + value + "times(value)");
    }
  }
}