#ifndef ATTRIBUTE_H
#define ATTRIBUTE_H

#include <string>
#include <map>
using namespace std;

class Attribute {
public:
    Attribute();
    Attribute(const string& name);
    string getName() const;
    void setName(const string& name);
    int getID() const;
    void setID(int aID);
private:
    string name;
    int id;
};

class Modifier : public Attribute {
public:
    Modifier();
    Modifier(const string& name);
    string getPropertyName() const;
    void setPropertyName(const string& propertyName);
    double getValue() const;
    void setValue(double value);
    bool isRemovable() const;
    void setRemovable(bool removable);
private:
    string propertyName;
    double value;
    bool removable;
};

#endif // ATTRIBUTE_H