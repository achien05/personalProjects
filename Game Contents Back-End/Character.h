#ifndef CHARACTER_H
#define CHARACTER_H
#include "Attribute.h"
#include <string>
using namespace std;

class Character {
public:
    Character();
private:
    string name;
    int health;
    int attack;
    int defense;
    int speed;
    int stamina;
};

#endif // CHARACTER_H