import platform
from pathlib import Path
import sys
from core.mod import Mod
#import vdf
        
def get_steam_apps_dir_path():
    system = platform.system()
    if system == "Windows":
        steam_apps_path = Path("C:/Program Files (x86)/Steam/steamapps")
    elif system == "Darwin" or system == "Linux":
        steam_apps_path = Path.home() / "Library/Application Support/Steam/steamapps"
    return steam_apps_path

#start/main
#choose game, run each parser to get dependencies, then build the nodes locally        
game = sys.argv[1]
game = game.lower()
match game:
    case "fallout3":
        print("FO3 WIP") #game folder
    case "falloutnv":
        print("FNV WIP") #game folder
    case "fallout4":
        print("FO4 WIP") #game folder
    case "rimworld":
        from parsers.rimworldXMLparser import *
        rw_mods = rimworld_scan_mods(get_steam_apps_dir_path())   #Mod format mods/Mod mods/Mod array
        for n in rw_mods:
            print(n.id)
        
    case "skyrimse":
        print("TESV:SE WIP")
    case _:
        print("Usage <program exe> <game name, as per below>")
        print("Supported Games: Fallout 3, Fallout NV, Fallout 4, Rimworld, Skyrim SE")


        

        
