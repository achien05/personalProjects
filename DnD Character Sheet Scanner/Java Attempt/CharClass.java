import java.util.ArrayList;

public class CharClass extends Attribute{
    private int level;
    public CharClass(){
    }
    public CharClass(String name, int level, String desc, String src, Modifier[] modifiers){
        super(name, desc, src, modifiers);
        this.level = level;
    }
    public int getLevel(){
        return this.level;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void levelUpClass(){

    }
    @Override
    public String toString(){
        String outString = super.getName() + "\n" + super.getDesc() + "\nFrom: " + super.getSource() + "\n" + "Level: " + level + "\n";
        ArrayList<Modifier> temp = super.getModifiers();
        for(int i = 0; i<temp.size(); i++){
            outString += (temp.get(i) + "\n");
        }
        return outString;
    }
}