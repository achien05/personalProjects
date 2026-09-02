public class Weapon extends Item{
    public enum WeaponType{SimpleMelee, SimpleRanged, MartialMelee, MartialRanged}
    private int damage;
    private int durability;
    WeaponType type;
    public Weapon(){
    }
    public int getDamage(){
        return this.damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getDurability(){
        return this.durability;
    }
    public void setDurability(int durability){
        this.durability = durability;
    }
    public WeaponType getWeaponType(){
        return this.type;
    }
    public void setWeaponType(WeaponType type){
        this.type = type;
    }
}