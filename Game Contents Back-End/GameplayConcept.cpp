#include <iostream>
#include <limits>
#include "GameAssets.h"
void main(int argc, char** argv){
    cout << "Welcome to _. Press Enter/Return to continue..." << endl;
    cin.ignore(numeric_limits<streamsize>::max(), '\n');
    cin.get();
    cout << "This is the realm of _. " << endl;


    cout << "Thank you for playing!" << endl;    
}