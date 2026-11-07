
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.util.Pair;
//relevant stat Strength = 0, Dex = 1, Con = 2, Int = 3, Wis = 4, Cha = 5, hit bonus = 6, attack bonus = 7, athl=8, acro=9, ..., persuasion = 25?

public class CharSheet{
    int[][] abilityScores = new int[6][];  //str, dex, con, int, wis, cha, and subabilities
    private int[] spellSlots = new int[9];           //total spell slots from 1 to 9
    private CharClass[] classLevels = new CharClass[13];        //levels for all the classes
    private String name;
    private int maxHP, currHP;
    private int totalLevel;                          //summation of class levels
    private int profBonus;                          //bonus to proficient skills based on level
    private int armorClass;                         //threshold to exceed to enable hits
    private int initiative;
    private int speed;
    private ArrayList<String> attackOptions = new ArrayList<String>();  //may replace with
    private ArrayList<Item> equippedGear = new ArrayList<Item>();   //weapons, armor, etc... equipped at the moment
    private ArrayList<Item> inventory = new ArrayList<Item>();      //all items stored in the backpack, inactive
    private CharRace race;              //attributes intrinsic to the character, sets of modifiers to be activated for rolls
    private Attribute bg;               //bg is pretty much a basic attribute as defined

    public CharSheet(String name, CharRace race, CharClass clas, Attribute bg){
        this.name = name;
        this.race = race;
        this.classLevels[0] = clas;
        this.bg = bg;    
        abilityScores[0] = new int[2];
        abilityScores[1] = new int[2];
        abilityScores[2] = new int[1];
        abilityScores[3] = new int[5];
        abilityScores[4] = new int[5];
        abilityScores[5] = new int[4];
    }

    public void resolveStats(){
        maxHP = 10; //adjust to match response from database, likely a roll
        currHP = 10; //adjust to match response from database, likely a roll
        speed = 30; //adjust to match response from database
        initiative = abilityScores[1][0];
        //total levels
        totalLevel = 0;
        for(int i = 0; i<classLevels.length; i++){
            totalLevel += classLevels[i].getLevel();
        }
        profBonus = (totalLevel>16) ? 6 : (totalLevel>12) ? 5 : (totalLevel>8) ? 4 : (totalLevel>4) ? 3:2;
        
    }
    public void attack(boolean adv, boolean two){
        if(two){
            if(adv){
                RollDice.roll2d20(this, adv);
            }
        }else{
            RollDice.rollD20(this);   //todo: modify the roll to access the character sheet's attribute's modifiers
        }
    }
    //public String toString(){
    //}

    public static void main(String[] args){
    //command line argument parsing
        String directoryStr;
        if(args.length < 0){
            System.out.println("No path found. Using default path: ./saves");
            directoryStr = "./saves";
        }else{
            directoryStr = args[0];
        }
        CharSheet characterSheet = CharSheetUtils.initalizeCharacterSheet(directoryStr);

    }
}