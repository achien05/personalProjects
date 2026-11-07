#ifndef ITEM_H
#define ITEM_H

#include <string>
#include <map>
#include "Attribute.h"
enum WeaponType {SimpleMelee, SimpleRanged, MartialMelee, MartialRanged};
enum ArmorType {Light, Medium, Heavy};
using namespace std;

class Item {
public:
    Item();
    Item(const string& name);
    string getName() const;
    void setName(const string& name);
    void addAttribute(const Attribute& Attribute);
    void removeAttribute(int id);
private:
    string name;
    map<int, Attribute> Attributes;    //<ID, Attribute>
};

class Weapon : public Item {
public:
    Weapon();
    Weapon(const string& name);
    int getDamage() const;
    void setDamage(int damage);
    int getDurability() const;
    void setDurability(int durability);
private:
    int damage;
    int durability;
    WeaponType type;
};

class Armor : public Item {
public:
    Armor();
    Armor(const string& name);
    int getDefenseBonus() const;
    void setDefenseBonus(int defenseBonus);
    int getDurability() const;
    void setDurability(int durability);
private:
    int DefenseBonus;
    int durability;
    ArmorType type;
};

class Ammo : public Item {
public:
    Ammo();
    Ammo(const string& name);
    int getDamage() const;
    void setDamage(int damage);
    int getQuantity() const;
    void setQuantity(int quantity);
private:
    int damage;
    int quantity;
};

class Consumable : public Item {
public:
    Consumable();
    Consumable(const string& name);
private:
    bool depletable;
};

#endif // ITEM_H