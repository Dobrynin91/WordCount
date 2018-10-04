
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
  public static void main(String[] args) throws IOException {

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    try {
      File file = new File("new1.txt");
      Scanner scanner = new Scanner(file);

      List<String> list = new ArrayList<>();
      while (scanner.hasNextLine()) {
        String[] arrayTime = scanner.nextLine().toLowerCase().split(" ");
        for (int i = 0; i < arrayTime.length; i++) {
          list.add(arrayTime[i]);
        }
      }
      scanner.close();
      String name = reader.readLine().toLowerCase();
      int wordCount = 0;
      for (int i = 0; i < list.size(); i++) {
        if (list.get(i).equals(name)) {
          wordCount++;
        }
      }
      printCount(wordCount);
    } catch (FileNotFoundException e) {
      System.out.println("Pathfile is not found");
    }
  }

  public static void printCount(int x) {
    System.out.println(x);
  }
}