public class Armor extends Item{
    public enum ArmorType {Light, Medium, Heavy}
    private int defenseBonus;
    private int durability;
    ArmorType type;
    public Armor(){
    }
    public int getDefenseBonus(){
        return this.defenseBonus;
    }
    public void setDefenseBonus(int defenseBonus){
        this.defenseBonus = defenseBonus;
    }
    public int getDurability(){
        return this.durability;
    }
    public void setDurability(int durability){
        this.durability = durability;
    }
    public ArmorType getArmorType(){
        return this.type;
    }
    public void setArmorType(ArmorType type){
        this.type = type;
    }
}