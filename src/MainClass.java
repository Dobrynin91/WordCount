
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
  public static void main(String[] args) throws IOException {

    File file = new File("E:\\Программы\\Обучение\\new 1.txt");
    Scanner scanner = new Scanner(file);

    List<String> list = new ArrayList<>();
    while (scanner.hasNextLine()) {
      String[] arrayTime = scanner.nextLine().split(" ");
      for (int i = 0; i < arrayTime.length; i++) {
        list.add(arrayTime[i]);
      }
    }
    scanner.close();
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String name = reader.readLine();

    int wordCount = 0;
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).equals(name)) {
        wordCount++;
      }
    }
    printCount(wordCount);
  }

  public static void printCount(int x) {
    System.out.println(x);
  }
}