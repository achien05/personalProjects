#ifndef ATTRIBUTE_H
#define ATTRIBUTE_H

#include <string>
#include <map>
#include <vector>
using namespace std;

class Modifier {
public:
    Modifier();
    Modifier(const string& name);
    string getName() const;                    //name of a modifier (spellcasting dc bonus, ac bonus, +1 of +1 greatswords)
    void setName(const string& propertyName);  
    float getValue() const;                    //boolean or used as intensity ()
    void setValue(float value);
    bool isRemovable() const;                   //could also be used as a status effect
    void setRemovable(bool removable);
private:
    string propertyName;
    float value;
    bool removable;
};

class Attribute {                               //more permanent than modifiers, typically containers of modifiers
public:
    Attribute();
    Attribute(const string& name);
    string getName() const;                     //name of the attribute/trait/feat
    void setName(const string& name);
private:
    int uses;
    string name;
    string desc;
    string source;
    string prereq;
    vector<Modifier> modifiers;
};

#endif // ATTRIBUTE_H