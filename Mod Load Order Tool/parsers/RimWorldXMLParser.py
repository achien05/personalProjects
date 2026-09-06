import os
import platform
from parsers.baseParser import GameModParser
from pathlib import Path
from core.ModClass import Mod
import xml.etree.ElementTree as ET

class RimWorldXMLParser(GameModParser):
    def __init__(self):
        self.mod_config = ET.parse(Path.home() / "AppData/LocalLow/Ludeon Studios/RimWorld by Ludeon Studios/Config/ModsConfig.xml")
        self.root = self.mod_config.getroot()
        self.active_mods = [mod.text for mod in self.root[1]]
        
    def scan_mods_folder(self, in_path):
        local_mods_path = in_path / "common/RimWorld/Mods"
        workshop_mods_path = in_path / "workshop/content/294100"
        game_files_list = [Mod("ludeon.rimworld", "Core", [], [], [], []), Mod("ludeon.rimworld.royalty", "Royalty", ["ludeon.rimworld"], ["ludeon.rimworld"], [], []), Mod("ludeon.rimworld.ideology", "Ideology", ["ludeon.rimworld, ludeon.rimworld.royalty"], ["ludeon.rimworld, ludeon.rimworld.royalty"], [], []), Mod("ludeon.rimworld.biotech", "Biotech", ["ludeon.rimworld, ludeon.rimworld.royalty, ludeon.rimworld.ideology"], ["ludeon.rimworld, ludeon.rimworld.royalty, ludeon.rimworld.ideology"], [], []), Mod("ludeon.rimworld.anomaly", "Anomaly", ["ludeon.rimworld, ludeon.rimworld.royalty, ludeon.rimworld.ideology, ludeon.rimworld.biotech"], ["ludeon.rimworld, ludeon.rimworld.royalty, ludeon.rimworld.ideology, ludeon.rimworld.biotech"], [], []), Mod("ludeon.rimworld.odyssey", "Odyssey", ["ludeon.rimworld, ludeon.rimworld.royalty, ludeon.rimworld.ideology, ludeon.rimworld.biotech, ludeon.rimworld.anomaly"], ["ludeon.rimworld, ludeon.rimworld.royalty, ludeon.rimworld.ideology, ludeon.rimworld.biotech, ludeon.rimworld.anomaly"], [], [])]
        #mods
        combined_list = game_files_list + self.read_mod_about_file(local_mods_path) + self.read_mod_about_file(workshop_mods_path)
        if(combined_list is None):
            return None
        else:
            return combined_list
    
    def read_mod_about_file(self, mod_dir_path):
        mod_list = []
        try:
            os.path.exists(mod_dir_path)            #check for existence
            os.path.isdir(mod_dir_path)             #check for directory
            mod_folders = [file for file in os.listdir(mod_dir_path) if file.isnumeric() and Path.is_dir(mod_dir_path / file) ]  #get all mods
            for mod_folder in mod_folders:
                if(not os.path.exists(mod_dir_path / mod_folder / "About")):
                    continue
                mod_about = ET.parse(mod_dir_path / mod_folder / "About/About.xml")
                mod_root = mod_about.getroot()
                #extract all aspects
                id = mod_root.find('packageId').text
                name = mod_root.find('name').text
                hard_dependencies = mod_root.findall('modDependencies/li/packageId')
                load_after = mod_root.findall('loadAfter/li/packageId')
                load_before = mod_root.findall('loadBefore/li/packageId')
                incompatible = mod_root.findall('incompatibleWith/li/packageId')
                #convert None to [] 
                hard_dependencies = [dependency.text for dependency in hard_dependencies] if hard_dependencies is not None else []
                load_after = [la.text for la in load_after] if load_after is not None else []
                load_before = [lb.text for lb in load_before] if load_before is not None else []
                incompatible = [incomp.text for incomp in incompatible] if incompatible is not None else []
                #add to list
                mod_list.append(Mod(id, name, hard_dependencies, load_after, load_before, incompatible))            
        except FileNotFoundError:
            print("Mod folder not found1")
            return None
        except NotADirectoryError:
            print("Mod folder not found2")
            return None
#debug: see what mods were detected
#        for mod in mod_list:
#           mod.to_string()
#        for mod in mod_list:
#        print([mod for mod in mod_list if mod.id in self.active_mods])
        return [mod for mod in mod_list if mod.id in self.active_mods]
    