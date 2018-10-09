import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Pattern;

public class TestClass {

    public static void main(String[] args) {
        File file = new File("new1.txt");
        Pattern pattern = Pattern.compile("\\p{Punct}|\\s");


        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("line = " + line);
                String[] split = pattern.split(line);
                for (String s : split) {
                    System.out.println("s = " + s);
                }

                //Matcher matcher = pattern.matcher(line);
//                if (!matcher.matches()) {
//                    System.out.println("don't match");
//                    continue;
//                }
//
//                for (int i = 0; i < matcher.groupCount(); i++) {
//                    String group = matcher.group(i);
//                    System.out.println("group = " + group);
//                }

            }
        } catch (Exception ignored) {

        }

    }
}
