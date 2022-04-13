import java.io.*;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        readFile();
        writeFile();
        readFile();
        deleteFile();
    }

    public static void createFile(){ // yeni bir dosya oluşturulması
        File file1=new File("C:\\Users\\hp\\Desktop\\workWithFiles\\students.txt");  // dosya yolunu belirt
        try {
            if(file1.createNewFile()){ // createNewFile yeni bir dosya oluşturmaya yarar boolean değer döndürür dosya oluşturulduysa true dosya zaten mevcutsa false değer döndürür. IO EXCEPTİON hatası verebilir bundan dolayı try catch kullanılmalı
                System.out.println("Doysa oluşturuldu...");
            }else{
                System.out.println("Dosya zaten mevcut...");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileInfo(){ // dosya bilgilerinin okunması
        File file1=new File("C:\\Users\\hp\\Desktop\\workWithFiles\\students.txt");
        if(file1.exists()){ // dosyasının o konumda var olup olmadığını test eder
            System.out.println("Dosya Yolu: "+file1.getAbsolutePath());
            System.out.println("Dosya adı: "+file1.getName());
            System.out.println("Dosya okunabilir mi: "+file1.canRead());
            System.out.println("Dosya yazılabilir mi: "+file1.canWrite());
            System.out.println("Dosya boyutu: (byte)"+file1.length());
        }
    }

    public static void readFile(){ // dosyanın içeriğinin okunması
        File file1=new File("C:\\Users\\hp\\Desktop\\workWithFiles\\students.txt");
       try{
           Scanner reader=new Scanner(file1);
           while (reader.hasNextLine()){ // okunacak satır oldugu sürece
              String data= reader.nextLine();
              System.out.println(data);
           }
           reader.close();
       }catch (FileNotFoundException e){
           e.printStackTrace();
       }
    }

    public static void writeFile(){ // dosyaya yazma işlemi

        try{
            BufferedWriter writer=new BufferedWriter(new FileWriter("C:\\Users\\hp\\Desktop\\workWithFiles\\students.txt",true)); // dosyayı üzerine yazma eklenebilir hale getir append parametresi ile
            writer.newLine(); // yeni bir satır oluştur
            writer.write("Ersev");
            System.out.println("Dosyaya yazıldı...");
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void deleteFile(){ // dosya silme
        File file1=new File("C:\\Users\\hp\\Desktop\\workWithFiles\\students.txt");
        if(file1.delete()){
            System.out.println("Dosya silindi: "+ file1.getName());
        }else{
            System.out.println("Dosya silinemedi");
        }
    }
}
