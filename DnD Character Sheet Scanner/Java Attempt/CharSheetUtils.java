import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class CharSheetUtils{
    public static CharSheet initalizeCharacterSheet(String directoryStr){
        File directoryPath = new File(directoryStr);
        if(directoryPath.exists() && directoryPath.isDirectory()){
        }else{
            System.out.println("Invalid directory path. Using default path: ./saves");
            directoryPath = new File("./saves");
        }
    //start of program (find adequate files, then select or create)
        System.out.println("Welcome to the DnD Character Sheet Hub.");
        System.out.println("Which character would you like to resume?");
        File selectedSheet = CharSheetUtils.selectCharacterSheet(directoryPath);
        if(selectedSheet == null){
            return null;
        }
        //read json formatted file from File selectedSheet (hopefully stores as a whole character sheet, seems like it)
        return; //return the built sheet
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
            //user input
            try{
                response = scanner.nextInt()-1;
                if(response >=0 && response < foundSheets.length){  //selected a valid sheet
                    System.out.println("Are you sure of " + foundSheets[response].getName() + "? (Y/y to confirm)");
                    confirmation = scanner.nextLine();
                    if(confirmation.equals("Y") || confirmation.equals("y")){
                        return foundSheets[response];
                    }
                }else if(response == -1){       //selected none
                    System.out.println("You have chosen none of them. Would you like to create a new sheet? (Y/y to confirm) (otherwise you exit(not much to do))");
                    confirmation = scanner.nextLine();
                    if(confirmation.equals("Y") || confirmation.equals("y")){
                        CharSheet newCharacter = null;
                        while(newCharacter == null){
                            newCharacter = CharSheetUtils.createCharacterSheet();
                            if(newCharacter == null){
                                System.out.println("Character creation failed. Trying again.");
                                continue;
                            }else{
                                System.out.println("Character creation complete. Saving.");
                                //save as file
                                return null; //replace with path
                            }
                        }
                    }else{
                        return null;
                    }
                }else{
                    System.out.println("Valid options range from 0 to " + foundSheets.length + ". Please try again.");
                    scanner.nextLine(); //flush
                }
            }catch(Exception e){
                System.out.println("Invalid input processing, please try again." + e.getMessage());
                scanner.nextLine(); //flush
            }finally{
                scanner.close();
            }
            //end user input (for eventual UI retrofit)
        }
    }
    public static CharSheet createCharacterSheet(){  //wip change from void to File upon development
        Scanner scanner = new Scanner(System.in); //user input
        String inputName, inputRace, inputClas, inputBg, response;
        CharSheet newCharacter = null;
        while(true){    
            System.out.println("Welcome to the character sheet creator. We will construct the fundamentals here. Let's start with your character's name.");
            try{
                //user input
                inputName = scanner.nextLine();
                System.out.println("Next, your character's race");
                inputRace = scanner.nextLine();
                System.out.println("Now, your character's starting class");
                inputClas = scanner.nextLine();
                System.out.println("Finally, your character's background");
                inputBg = scanner.nextLine();
                //Attribute race = CharSheetUtils.getMatchingRaceDetails();
                //Attribute class = CharSheetUtils.getMatchingClassDetails();
                //Attribute bg = CharSheetUtils.getMatchingBGDetails();
                //newCharacter = new CharSheet(/*plug in here later */);
                System.out.println("Is this correct? (Y/y to confirm)\n " + newCharacter);
                response = scanner.nextLine();
                if(response.equals("Y") || response.equals("y")){
                    break;
                }
                //end user input: replace with all at once editable submission (if no, it cancels and allows edits by looping around)
            }catch(Exception e){
                System.out.println("Invalid input processing, please try again." + e.getMessage());
                scanner.nextLine(); //flush
            }finally{
                scanner.close();
            }
        }
        if(newCharacter == null){
            return null;
        }else{
            return newCharacter;
        }
    }
    public static int saveCharacterSheet(){
        return 1;
    }
    public static void getMatchingRaceDetails(){
    }
    public static void getMatchingClassDetails(){
    }
    public static void getMatchingBGDetails(){
    }

}