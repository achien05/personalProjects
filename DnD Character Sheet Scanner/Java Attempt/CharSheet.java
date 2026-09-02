
import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;


public class CharSheet{
    public static void main(String[] args){
        String directoryStr;
        if(args.length < 0){
            System.out.println("No path found. Using default path: ./saves");
            directoryStr = "./saves";
        }else{
            directoryStr = args[0];
        }
        File directoryPath = new File(directoryStr);
        if(directoryPath.exists() && directoryPath.isDirectory()){
        }else{
            System.out.println("Invalid directory path. Using default path: ./saves");
            directoryPath = new File("./saves");
        }
        System.out.println("Welcome to the DnD Character Sheet Hub.");
        System.out.println("Which character would you like to resume?");
        File selectedSheet = CharSheet.selectCharacterSheet(directoryPath);
        if(selectedSheet == null){
            return;
        }
        //read json formatted file from File selectedSheet

    }

    public static File selectCharacterSheet(File directoryPath){
        System.out.println("0: None of these");
        FilenameFilter dndFormat = (dir, name)->name.endsWith(".dnd");  //credit: https://www.baeldung.com/java-filename-filter
        File[] foundSheets = directoryPath.listFiles(dndFormat);
        Scanner scanner = new Scanner(System.in);
        int response = -1;
        String confirmation;
        while(true){
            for(int i = 0; i<foundSheets.length; i++){
                System.out.println(i+1 + ": " + foundSheets[i].getName());
            }
            try{
                response = scanner.nextInt()-1;
                if(response >=0 && response < foundSheets.length){
                    System.out.println("Are you sure of " + foundSheets[response].getName() + "? (Y/y to confirm)");
                    confirmation = scanner.nextLine();
                    if(confirmation.equals("Y") || confirmation.equals("y")){
                        return foundSheets[response];
                    }
                }else if(response == -1){
                    System.out.println("You have chosen none of them. Would you like to create a new sheet? (Y/y to confirm)");
                    confirmation = scanner.nextLine();
                    if(confirmation.equals("Y") || confirmation.equals("y")){
                        CharSheet.createCharacterSheet();
                    }else{
                        return null;
                    }
                }else{
                    System.out.println("Valid options range from 0 to " + foundSheets.length+1 + ". Please try again.");
                    scanner.nextLine(); //flush
                }
            }catch(Exception e){
                System.out.println("Invalid input processing, please try again." + e.getMessage());
                scanner.nextLine(); //flush
            }finally{
                scanner.close();
            }
        }
    }

    public static void createCharacterSheet(){  //wip change from void to File upon development
    }
}