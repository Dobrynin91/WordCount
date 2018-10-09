import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestClass {

    public static void main(String[] args) {
        File file = new File("new1.txt");
        Pattern pattern = Pattern.compile("([а-яА-Я0-9]+)");


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (!matcher.matches()) continue;

                for (int i = 1; i < matcher.groupCount(); i++) {
                    String group = matcher.group(i);
                    System.out.println("group = " + group);
                }

            }
        } catch (Exception ignored) {

        }

    }
}
