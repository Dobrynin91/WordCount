import java.io.*;
import java.util.ArrayList;

public class MainClass {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String requestWord = reader.readLine().toLowerCase();

    int wordCount = 0;

    File file = new File("new1.txt");

    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        ArrayList<String> list = new ArrayList<>();
        String[] arrayTime = line.toLowerCase().split(" ");
        for (int i = 0; i < arrayTime.length; i++) {
          list.add(arrayTime[i]);
          for (int j = 0; j < list.size(); j++) {
            if (list.get(i).equals(requestWord)) {
              wordCount++;
            }
          }
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("The pathfile is not found");
    }
    printCount(wordCount);
  }

  private static void printCount(int x) {
    System.out.println(x);
  }
}