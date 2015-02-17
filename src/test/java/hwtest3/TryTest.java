package hwtest3;

import hw3.RealType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TryTest {

    @BeforeTest
    public void before(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("file.txt", "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.println("There is a number 9.9 in this string");
        writer.close();
    }

    @Test
    public void someTest() {
       String s = readFile("file.txt");
      boolean result =  checkReal(s);

        Assert.assertEquals(result, true);
    }

    @AfterTest
    public void after(){
        try{

            File file = new File("file.txt");

            if(file.delete()){
                System.out.println(file.getName() + " is deleted!");
            }else{
                System.out.println("Delete operation is failed.");
            }

        }catch(Exception e){

            e.printStackTrace();

        }
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

    public boolean checkReal(String str){
        boolean result = false;

        String delims = "[ ]";
        String[] tokens = str.split(delims);
        RealType rt = new RealType();

        for(String s: tokens){
            if (rt.verification(s)){
                result = true;
                return result;
            }
        }
        return result;
    }
}
