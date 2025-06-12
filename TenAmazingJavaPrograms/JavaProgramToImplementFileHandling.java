import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.io.File;
import java.util.Scanner;

class FileHandeler {
    public File openFile(String filename) {
        File file = new File(filename);
        return file;

    }

    public File createFile(String filename) {
        try {
            File file = new File(filename);
            file.createNewFile();
            return file;
        } 
        catch (FileAlreadyExistsException e) {
            System.out.println("File Already exists");
            return null;
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            return null;
        }
    }

    public void renameFile(String oldname, String newname) {
        File oldfile = new File(oldname);
        File newfile = new File(newname);
        if(oldfile.renameTo(newfile)) {
            System.out.println("File Renamed Successfully");
        } else {
            System.out.println("Error : Cannot Rename File");
        }
    }

    public void copyFile(File copyfileobj, File fileobj) throws IOException {
        copyFile(copyfileobj, fileobj, false);
    }
    public void copyFile(File copyfileobj, File fileobj, boolean append) throws IOException {
        copyFile(copyfileobj.getName(), fileobj.getName(), append);
    }
    public void copyFile(String copyfilename, String filename, boolean append) {
        try {    
            FileReader file = new FileReader(filename);
            FileWriter copyfile = new FileWriter(copyfilename, append);
            BufferedReader bufferreader = new BufferedReader(file);
            
            String buffer;
            while ((buffer = bufferreader.readLine()) != null) {
                System.out.println(buffer+"\n");
                copyfile.write(buffer+"\n");
            }
            file.close();
            copyfile.close();
        } 
        catch(FileNotFoundException e) {
            System.out.println("Error : File not Found");
        }
        catch (IOException e) {
            System.out.println("Error : cannot display File");
        }
    }
    
    public void readFile(File file, boolean displayflag) throws IOException {
        readFile(file.getName(), displayflag);
    }
    public FileReader readFile(File file) throws IOException {
        return readFile(file.getName());
    }
    public FileReader readFile(String filename) {
        try {
            FileReader readfile = new FileReader(filename);
            return readfile;
        }
        catch(FileNotFoundException e) {
            System.out.print("Error : File is not Found");
            return null;
        }
    }

    public void readFile(String filename, boolean displayflag) throws IOException {
        try {    
            if(displayflag) {
                FileReader file = readFile(filename);
                BufferedReader bufferreader = new BufferedReader(file);
                String buffer;
                while ((buffer = bufferreader.readLine()) != null) {
                    System.out.println(buffer);
                }
                file.close();
            }
        } 
        catch (IOException e) {
            System.out.println("Error : cannot display File");
        }
    }

    public void writeLinesInFile(String filename, String[] lines) {
        for(String line: lines){   
            writeLineInFile(filename,line);
        }
    }
    public void writeLinesInFile(File file, String[] lines) {
        for(String line: lines){   
            writeLineInFile(file.getName(),line);
        }
    }
    public void writeLineInFile(File file, String line) {
        writeLineInFile(file.getName(),line);
    }
    public void writeLineInFile(String filename,String line) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(line);
            writer.newLine(); 
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public boolean deleteFile(File file) {
        return deleteFile(file.getName());
    }
    public boolean deleteFile(String filename) { 
        File file = new File(filename);
        if(file.delete()) {
            return true;
        }
        return false;
    }

}

class Crud extends FileHandeler{
    Scanner scan = new Scanner(System.in);
    boolean flag = true;
    private int menu() {
        System.out.print("""
        +-------------------------------------------------------+
        |            Welcome To CRUD Service Software           |
        +------+------------------------------------------------+
        |  1.  |        Create File                             |
        +------+------------------------------------------------+
        |  2.  |        Read File                               |
        +------+------------------------------------------------+
        |  3.  |        Write File                              |
        +------+------------------------------------------------+
        |  4.  |        Copy File                               |
        +------+------------------------------------------------+
        |  5.  |        Delete File                             |
        +------+------------------------------------------------+
        |  6.  |        Rename File                             |
        +------+------------------------------------------------+
        |  Enter Your Choice = >""");
            return scan.nextInt();
    }
    private String input(String prompt) {
        System.out.print(prompt);
        String inp = scan.nextLine();
        inp = scan.nextLine();
        return inp;
    }

    private void mainloop() throws IOException {
        switch (menu()) {
            case 1 -> {
                createFile(input("Enter File name : "));

            }
            case 2 -> {
                readFile(input("Enter File name : "), true);
                input("");
            }
            case 3 -> {
                String filename = input("Enter File name :");
                System.out.println("NOTE Type \":EOF<save>\" to save and exit the file");
                System.out.println("=========="+filename+"============");
                String buffer = input("");
                while(!buffer.equals(":EOF<save>")){
                    writeLineInFile(filename, buffer);
                    buffer = scan.nextLine();
                }
            }
            case 4 -> {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter Source File name : ");
                String source = scan.nextLine();
                System.out.print("Enter Destination File name : ");
                String destination =  scan.nextLine();
                copyFile(destination, source, false);
            }
            case 5 -> {
                deleteFile(input("Enter File name : "));
            }
            case 6 -> {
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter old name : ");
                String oldname = scan.nextLine();
                System.out.print("Enter new name : ");
                String newname =  scan.nextLine();
                renameFile(oldname, newname);
            }
            default -> {
                flag = false;
            }
        }
    }
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public void start() throws Exception {
        while(flag){
            clear();
            mainloop();
        };
    }
}
public class JavaProgramToImplementFileHandling {
    public static void main(String[] args) throws Exception{
        Crud software = new Crud();
        software.start();
    }
}