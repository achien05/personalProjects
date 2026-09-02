import java.util.ArrayList;

public class Item{
    private boolean active = true;
    private String name;
    private ArrayList<Modifier> modifiers = new ArrayList<Modifier>();

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public ArrayList<Modifier> getModifiers(){  //provides copies for use(modification or standard usage)
        return new ArrayList<Modifier>(modifiers);
    }
    public void setModifier(Modifier modifier){ //will replace the modifier with the same (except for a minor change)
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
    public boolean isActive(){
        return this.active;
    }
    public void toggleActive(){
        this.active = !this.active;
    }
}