#ifndef ITEM_H
#define ITEM_H

#include <string>
#include <map>
#include "Attribute.h"
using namespace std;

class Item {
public:
    Item();
    Item(const string& name);
    string getName() const;
    void setName(const string& name);
private:
    string name;
};

class Weapon : public Item {
public:
    Weapon();
    Weapon(const string& name);
    int getDamage() const;
    void setDamage(int damage);
    int getDurability() const;
    void setDurability(int durability);
    void addModifier(const Modifier& modifier);
    void removeModifier(int id);
private:
    map<int, Modifier> modifiers;    //<ID, Modifier>
    int damage;
    int durability;
};

class Armor : public Item {
public:
    Armor();
    Armor(const string& name);
    int getDefenseBonus() const;
    void setDefenseBonus(int defenseBonus);
    int getDurability() const;
    void setDurability(int durability);
    void addModifier(const Modifier& modifier);
    void removeModifier(int id);
private:
    map<int, Modifier> modifiers;    //<ID, Modifier>
    int DefenseBonus;
    int durability;
};

class Ammo : public Item {
public:
    Ammo();
    Ammo(const string& name);
    int getDamage() const;
    void setDamage(int damage);
    int getQuantity() const;
    void setQuantity(int quantity);
    void addModifier(const Modifier& modifier);
    void removeModifier(int id);
private:
    map<int, Modifier> modifiers;    //<ID, Modifier>
    int damage;
    int quantity;
};

class Consumable : public Item {
public:
    Consumable();
    Consumable(const string& name);
    void addModifier(const Modifier& modifier);
    void removeModifier(int id);
private:
    map<int, Modifier> modifiers;    //<ID, Modifier>
    bool depletable;
};

#endif // ITEM_H