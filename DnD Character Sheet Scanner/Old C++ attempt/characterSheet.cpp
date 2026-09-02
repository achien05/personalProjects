/*
#include <iostream>
#include <filesystem>
#include <vector>
#include <string>
#include <fstream>
using namespace std;
namespace fs = std::filesystem;
*/
#include "characterSheetUtlities.h"

fs::path targetDir = "./saves";                                                 //scan for character sheet files in the target directory
bool staleSheetList = false;

int characterSheetUseLoop(Character& playerCharacter){

}

int main(int argc, char** argv){
    vector<fs::path> characterSheets;
    Character playerCharacter;
    if(argc<2){
        cout << "No target directory specified. Using default: ./saves" << endl;
    }else if(argc>1 && fs::exists(fs::path(argv[1])) && fs::is_directory(fs::path(argv[1]))){
        targetDir = fs::path(argv[1]);
    }else{
        cout << "Invalid target directory." << endl;
        cout << "Usage: " << argv[0] << " <target_directory>" << endl;
        return 1;
    }
    
    cout << "Welcome to the DnD Character Sheet Hub." << endl;
    cout << "Which character would you like to resume?" << endl;
    scanCharacterSheets(characterSheets);                                               //scan
    int characterSheetIdx = -1;
    if(characterSheets.empty()) {                                                       //if empty, create a new sheet at index 0
        cout << "No character sheets found." << endl;
        createCharacterSheet(characterSheets);
        characterSheetIdx = 0;
    }else{                                                                              //otherwise, select
        characterSheetIdx = selectCharacterSheet(characterSheets);
    }
    if(characterSheetIdx < 0) {                                                         //if none selected, exit                             
        return 0;
    }else if(characterSheetIdx >= 0 && characterSheetIdx < characterSheets.size()){     //if selected, load
        loadCharacterSheet(playerCharacter, characterSheets[characterSheetIdx]);
    }
    characterSheetUseLoop(playerCharacter);

    cout << "Bye" << endl;
    return 0;
}

void scanCharacterSheets(vector<fs::path>& characterSheets) {
    if(staleSheetList) {
        cout << "Refreshing character sheets" << endl;
        staleSheetList = false;
    }
    characterSheets.clear();
    for(const auto& entry : fs::directory_iterator(targetDir)) {
        if(entry.is_regular_file() && entry.path().extension() == ".dnd") {
            cout << "Found character sheet: " << entry.path().filename() << endl;
            characterSheets.push_back(entry.path().filename());
        }
    }
}
void listCharacterSheets(const vector<fs::path>& characterSheets) {
    for(ulong i = 1; i <= characterSheets.size(); i++) {
        cout << i <<": " << characterSheets.at(i-1) << endl;
    }
}
int selectCharacterSheet(vector<fs::path>& characterSheets) {
    int choice;
    while(true){
        cout << "Choose which character sheet to resume:" << endl;                      //provide user with means to select
        cout << "0: None of these" << endl;
        listCharacterSheets(characterSheets);
        cout << "I want to resume: " << flush;
        cin >> choice;
        if(choice == 0) {
            cout << "No character sheet selected." << endl;
            createCharacterSheet(characterSheets);
            staleSheetList = true;
            scanCharacterSheets(characterSheets);
            continue;
        }
        if(choice >= 1 && choice <= characterSheets.size()) {
            cout << "Resuming:" << characterSheets.at(choice-1) << endl;
            return choice-1;
        }
        cout << "You made an error? Try again? (Y)es/(N)o" << endl;
        cin >> choice;
        if(choice == 'N' || choice == 'n') {
            return -1;
        }
    }
}

void createCharacterSheet(vector<fs::path>& characterSheets) {
    cout << "Would you like to create a new character sheet? (Y)es/(N)o" << endl;
    char choice;
    cin >> choice;
    if(choice == 'Y' || choice == 'y') {
        cout << "Creating a new character sheet..." << endl;
        //create a new character object and then create a format to save the object to a file
        Character newCharacter;
        staleSheetList = true;
        scanCharacterSheets(characterSheets);
    }else{
        return;
    }
}

void loadCharacterSheet(Character& playerCharacter, const fs::path& characterSheetPath) {
    fstream characterFile(characterSheetPath);

}

void saveCharacterSheet(){

}