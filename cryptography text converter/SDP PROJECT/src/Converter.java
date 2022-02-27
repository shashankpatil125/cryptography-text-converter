import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Converter {

    public static void arrmanage(String plaintext, char[] arrtext){
        int n=plaintext.length();
        for(int i=0;i<n;i++)
        {
            arrtext[i]=plaintext.charAt(i);
        }
    }

    public static void plaintextconvert(char[]chenged, int key){
        char[] alphabate=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int j=0;j<key;j++) {
            for (int i = 0; i < 25; i++) {
                char temp = alphabate[i];
                alphabate[i] = alphabate[i + 1];
                alphabate[i + 1] = temp;
            }
        }

        for(int i=0;i<26;i++)
        {
            chenged[i]=alphabate[i];
        }
    }

    public static String conversion(String message , int key,char[] chenged){
        String s="";
        char[] alphabate=new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for(int i=0;i<message.length();i++)
        {
            for(int j=0;j<26;j++)
            {
                if(message.charAt(i)==alphabate[j])
                {
                    s+=chenged[j];
                }
            }
        }
        return s;
    }

    public static String readfile() {
        String plaintext="";
        try {
            File myObj = new File("Text.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                plaintext = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return plaintext;
    }

    public static void writeFile(String data) {
        try {
            FileWriter myWriter = new FileWriter("Text.txt");
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully write to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void convertfile(String data){
        try {
            FileWriter myWriter = new FileWriter("Text.txt");
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully write to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void menu() {
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter the data you want to write into Text file");
        String data_input=sc.nextLine();
        writeFile(data_input);

        String plaintext=readfile();
        char[] arrtext=new char[plaintext.length()];
        char[] chenged=new char[26];
        arrmanage(plaintext,arrtext);
        System.out.println("Enter the key ");
        int key=sc.nextInt();
        plaintextconvert(chenged, key);
        System.out.println(conversion(plaintext,key,chenged));
        String convertedmessage=conversion(plaintext,key,chenged);
        convertfile(convertedmessage);

        System.out.println("press '1' for reveal message or press '2' for continue");
        int gonext=sc.nextInt();
        if(gonext==1)
        {
            System.out.println("Enter the key");
            int security_code = sc.nextInt();

            if (key == security_code) {
                System.out.println(plaintext);
                writeFile(plaintext);
            }
            else {
                System.out.println("wrong key you cant see secured message");
            }
        }
        else{
            System.out.println("exit");
        }
    }

    public static void main(String[] args) {
        menu();
    }
}










