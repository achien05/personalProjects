public class Modifier{
    public Modifier(){
    }
    private boolean active = true;  //is active for the roll (won't need to edit )
    private int value = 0;          //value, severity, saturation. All synonyms for this idea of presence. Boolean of binary-style modifiers (e.g: greatsword proficiency). Applies proficiency modifier.
    private int relevStat;          //which stat is being affected
    private String name = "";

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public boolean getActive(){
        return this.active;
    }
    public int getValue(){
        return this.value;
    }
    public void setValue(int value){
        this.value = value;
    }
    public boolean isActive(){
        return this.active;
    }
    public void toggleActive(){
        this.active = !this.active;
    }
    public int getRelStat(){
        return this.relevStat;
    }
    public void setRelStat(int relevStat){
        this.relevStat=relevStat;
    }
}