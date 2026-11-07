public class Consumable extends Item{
    public Consumable(){
    }
    boolean depletable = true;
    public boolean getDepeletable(){
        return this.depletable;
    }
    public void setDepletable(boolean depletable){
        this.depletable=depletable;
    }
}