package functional;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lesson3 {

    public String s = "h";

    @Test
    public void someTest() {
    String v = readFile("file.txt");

        Assert.assertEquals(v, s);
    }

    public String readFile(String filename)
    {
        String content = null;
        File file = new File(filename); //for ex foo.txt
        try {
            FileReader reader = new FileReader(file);
            char[] chars = new char[(int) file.length()];
            reader.read(chars);
            content = new String(chars);
            reader.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return content;
    }

}
