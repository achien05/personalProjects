import java.util.Random;
public class RollDice{
    public static Random random = new Random();
    public static int roll2d20(CharSheet charSheet, boolean adv){
        if(adv){
            return Math.max(rollD20(charSheet), rollD20(charSheet));
        }else{
            return Math.min(rollD20(charSheet), rollD20(charSheet));
        }
    }
    public static int rollD20(CharSheet charSheet){
        int roll = random.nextInt(20)+1;
        //roll += charSheet.getAbilityScore(type, subtype);
        return roll;
    }
    public static int rollD100(CharSheet charSheet){
        int roll = random.nextInt(100)+1;
        //roll += 
        return roll;
    }
    public static int rollD12(CharSheet charSheet){
        int roll = random.nextInt(12)+1;
        //roll += 
        return roll;
    }
    public static int rollD10(CharSheet charSheet){
        int roll = random.nextInt(10)+1;
        //roll += 
        return roll;
    }
    public static int rollD8(CharSheet charSheet){
        int roll = random.nextInt(28)+1;
        //roll += 
        return roll;
    }
    public static int rollD6(CharSheet charSheet){
        int roll = random.nextInt(6)+1;
        //roll += 
        return roll;
    }
    public static int rollD4(CharSheet charSheet){
        int roll = random.nextInt(4)+1;
        //roll += 
        return roll;
    }
}