import java.util.ArrayList;

public class Attribute{
    private ArrayList<Modifier> modifiers = new ArrayList<Modifier>();
    private String name = "";
    private String desc = "";
    private String src = "";
    private String prereq = "";
    private int uses;
    private int attrID;

    public Attribute(String name, int uses, int attrID){
        this.name = name;
        this.uses = uses;
        this.attrID = attrID;
    }
    public Attribute(String name, int uses, int attrID, Modifier[] modifiers){
        this.name = name;
        this.uses = uses;
        this.attrID = attrID;
        for(int i = 0; i < modifiers.length;i++){
            this.modifiers.add(modifiers[i]);
        }
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getUses(){
        return this.uses;
    }
    public void setUses(int uses){
        this.uses = uses;
    }
    public String getDesc(){
        return this.desc;
    }
    public void setDesc(String desc){
        this.desc=desc;
    }
    public String getSource(){
        return this.src;
    }
    public void setSource(String src){
        this.src=src;
    }
    public String getPreReqs(){
        return this.prereq;
    }
    public void setPreReqs(String prereq){
        this.prereq=prereq;
    }
    public ArrayList<Modifier> getModifiers(){  //provides copies for use(modification or standard usage)
        return new ArrayList<Modifier>(modifiers);
    }
    public void addModifier(Modifier modifier){
        modifiers.add(modifier);
    }
    public void updateModifier(Modifier modifier){ //will replace the modifier with the same (except for a minor change)
        for(int i = 0; i<modifiers.size(); i++){
            if(modifiers.get(i).getName().equals(modifier.getName())){
                modifiers.set(i, modifier);
                break;
            }
        }
    }
    public void removeModifier(Modifier modifier){
        for(int i = 0; i<modifiers.size(); i++){
            if(modifiers.get(i).getName().equals(modifier.getName())){
                modifiers.remove(i);
                break;
            }
        }
    }
    public int getAttrID(){
        return this.attrID;
    }
    public void setAttrID(int attrID){
        this.attrID = attrID;
    }

    public void applyAttrMods(){
        for(int i = 0; i<modifiers.size(); i++){
            modifiers.get(i).getRelStat();
            modifiers.get(i).getValue();
        }
    }
}