import java.util.ArrayList;
import java.util.UUID;
//for database?
//Classes: O is Barbarian, 1 is bard, 2 is cleric, ..., 11 is wizard
//Races: 12 is Aasimar, 13 is dragonborn, 14 is dwarf, ..., 21 is Tiefling
//Backgrounds: 22 is Acolyte, 23 is Artisan, 24 is Charlatan, ..., 37 is Wayfarer
//Feats: 38 is Ability Score Improvement, 39 is Actor, 40 is Alert, ..., 11o is Weapon Master

public class Attribute{
    private final UUID attrID = UUID.randomUUID();    
    private String name;
    private String desc;
    private String src;
    private ArrayList<Modifier> modifiers = new ArrayList<Modifier>();

    public Attribute(){
    }
    public Attribute(String name){
        this.name = name;
    }
    public Attribute(String name, String desc, String src, Modifier[] modifiers){
        this.name = name;
        this.desc = desc;
        this.src = src;
        for(int i = 0; i < modifiers.length;i++){
            this.modifiers.add(modifiers[i]);
        }
    }
    //name
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    //desc
    public String getDesc(){
        return this.desc;
    }
    public void setDesc(String desc){
        this.desc=desc;
    }
    //source/origin
    public String getSource(){
        return this.src;
    }
    public void setSource(String src){
        this.src=src;
    }
    //modifiers of the attr
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
    //ID to be replaced w/ database ID
    public UUID getAttrID(){
        return this.attrID;
    }
    //get and apply Attr (somehow)
    public int applyAttrMods(int relevantStat){
        int rollModifier = 0;
        for(int i = 0; i<modifiers.size(); i++){
            if(relevantStat == modifiers.get(i).getRelStat()){
                i += modifiers.get(i).getValue();
            }
        }
        return rollModifier;
    }
    @Override
    public String toString(){
        String outString = name + "\n" + desc + "\nFrom: " + src + "\n";
        for(int i = 0; i<modifiers.size(); i++){
            outString += (modifiers.get(i) + "\n");
        }
        return outString;
    }
}