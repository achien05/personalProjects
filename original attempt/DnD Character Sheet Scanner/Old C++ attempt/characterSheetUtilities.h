#ifndef CHARACTER_SHEET_UTILITIES_H
#define CHARACTER_SHEET_UTILITIES_H

#include <iostream>
#include <filesystem>
#include <vector>
#include <string>
#include <fstream>
#include "Attribute.h"
using namespace std;
namespace fs = std::filesystem;

void scanCharacterSheets(vector<fs::path>&);
void listCharacterSheets(const vector<fs::path>&);
void selectCharacterSheet(const vector<fs::path>&);
void createCharacterSheet(vector<fs::path>&);
void loadCharacterSheet(Character&, const vector<fs::path>&);

class CharClass{
public:
    CharClass();
    ~CharClass();
    string toString(){
}
private:
    
    int level;
};

class Race{
public:
Race();
~Race();
string toString(){
}
private:
string name;
};

class CharBG{
public:
CharBG();
~CharBG();
string toString(){
}
private:
string name;
};

class Character{
public:
    Character(){
        updateCharacterStats();
    };
    ~Character();
    void levelUp(){
        totalLevel+=1;
        updateCharacterStats();
    }
    void updateCharacterStats(){
        armorClass = 10 + abilityScores[1][0];
        initiative = abilityScores[1][0];
        if(totalLevel >=1 && totalLevel <= 4){
            proficiencyBonus = 2;
        }else if(totalLevel >= 5 && totalLevel <= 8){
            proficiencyBonus = 3;
        }else if(totalLevel >= 9 && totalLevel <= 12){
            proficiencyBonus = 4;
        }else if(totalLevel >= 13 && totalLevel <= 16){
            proficiencyBonus = 5;
        }else if(totalLevel >= 17 && totalLevel <= 20){
            proficiencyBonus = 6;
        }
    }
private:
    CharClass classes[13];  //artificer, barbarian, bard, cleric, druid, fighter, monk, paladin, ranger, rogue, sorcerer, warlock, wizard respectively
    Race race;
    CharBG background;
    string name;
    vector<int> spellSlots{9}, maxSpellSlots{9};
    int totalLevel;
    int abilityScores[6][7];    //strength, dexterity, constitution, intelligence, wisdom, charisma, and their skills
    int maxHitPoints;
    int hitPoints;
    int armorClass = 10;
    int initiative = 0;
    int proficiencyBonus = 2;
    int speed = 30;
    bool hasMagic = false;
};


#endif // CHARACTER_SHEET_UTILITIES_H