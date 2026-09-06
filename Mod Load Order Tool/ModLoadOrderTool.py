import platform
from pathlib import Path
import sys
from parsers.RimWorldXMLParser import *
from core.ModClass import Mod
from core.graph import *
#import vdf
        
def get_steam_apps_dir_path():
    system = platform.system()
    if system == "Windows":
        steam_apps_path = Path("C:/Program Files (x86)/Steam/steamapps")
    elif system == "Darwin" or system == "Linux":
        steam_apps_path = Path.home() / "Library/Application Support/Steam/steamapps"
    return steam_apps_path
#def wipVDF():
#    vdf_path = steam_path / "steamapps/libraryfolders.vdf"
#        
#        if vdf_path.exists():
#            with open(vdf_path, "r", encoding = "utf-8") as f:
#                data = vdf.load(f)
#                print(data)       
#        else:
#            return
    

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
    case "minecraft":
        print("MC WIP") #mods folder
    case "rimworld":
        from parsers.RimWorldXMLParser import *
        rim_parser = RimWorldXMLParser()
        mod_mods = rim_parser.scan_mods_folder(get_steam_apps_dir_path())   #Mod format mods/Mod mods/Mod array
        for n in mod_mods:
            print(n.id)
        
    case "skyrimse":
        print("TESV:SE WIP")
    case _:
        print("Usage <program exe> <game name, as per below>")
        print("Supported Games: Fallout 3, Fallout NV, Fallout 4, Minecraft, Rimworld, Skyrim SE")


        

        
