from core.mod import Mod
import os
from pathlib import Path
import xml.etree.ElementTree as ET

#WIP: need to add relation contra-symmetry: A says A->B, but B has no idea of A, need to add to B<-A to B
#WIP: need to filter mods not loaded: may be in the dependencies list, but will never reach 0 if they're not included to exhaust
def rimworld_scan_mods(in_path):
    mod_config = ET.parse(Path.home() / "AppData/LocalLow/Ludeon Studios/RimWorld by Ludeon Studios/Config/ModsConfig.xml")
    root = mod_config.getroot()
    active_mods = [mod.text for mod in root[1]]
    local_mods_path = in_path / "common/RimWorld/Mods"
    workshop_mods_path = in_path / "workshop/content/294100"
    core_game=[Mod("ludeon.rimworld", "Core", [], ["ludeon.rimworld.royalty","ludeon.rimworld.ideology","ludeon.rimworld.biotech","ludeon.rimworld.anomaly","ludeon.rimworld.odyssey"]), 
               Mod("ludeon.rimworld.royalty", "Royalty", ["ludeon.rimworld"], ["ludeon.rimworld.ideology","ludeon.rimworld.biotech","ludeon.rimworld.anomaly","ludeon.rimworld.odyssey"]),
               Mod("ludeon.rimworld.ideology", "Ideology", ["ludeon.rimworld","ludeon.rimworld.royalty"], ["ludeon.rimworld.biotech","ludeon.rimworld.anomaly","ludeon.rimworld.odyssey"]),
               Mod("ludeon.rimworld.biotech", "Biotech", ["ludeon.rimworld","ludeon.rimworld.royalty","ludeon.rimworld.ideology"], ["ludeon.rimworld.anomaly","ludeon.rimworld.odyssey"]),
               Mod("ludeon.rimworld.anomaly", "Anomaly", ["ludeon.rimworld","ludeon.rimworld.royalty","ludeon.rimworld.ideology","ludeon.rimworld.biotech"], ["ludeon.rimworld.odyssey"]),
               Mod("ludeon.rimworld.odyssey", "Odyssey", ["ludeon.rimworld","ludeon.rimworld.royalty","ludeon.rimworld.ideology","ludeon.rimworld.biotech","ludeon.rimworld.anomaly"], [])]
    steam_list=scan_folders(workshop_mods_path, active_mods)
    local_list=scan_folders(local_mods_path, active_mods)
    full_list=core_game+steam_list+local_list
    return full_list
def scan_folders(mod_dir_path, active_mods):
    mod_list=[]
    try:
        os.path.exists(mod_dir_path)            #check for existence
        os.path.isdir(mod_dir_path)             #check for directory
        mod_folders = [file for file in os.listdir(mod_dir_path) if Path.is_dir(mod_dir_path / file) ]  #get all mods
        for mod_folder in mod_folders:
            if(not os.path.exists(mod_dir_path / mod_folder / "About")):
                continue
            
            mod_about = ET.parse(mod_dir_path / mod_folder / "About/About.xml")
            mod_root = mod_about.getroot()
            id = mod_root.find('packageId').text
            name = mod_root.find('name').text
            
            hard_dependencies = mod_root.findall('modDependencies/li/packageId')
            load_after = mod_root.findall('loadAfter/li/packageId')
            load_before = mod_root.findall('loadBefore/li/packageId')
            incompatible = mod_root.findall('incompatibleWith/li/packageId')
            
            hard_dependencies = [dependency.text for dependency in hard_dependencies] if hard_dependencies is not None else []
            load_after = [la.text for la in load_after] if load_after is not None else []
            load_before = [lb.text for lb in load_before] if load_before is not None else []
            incompatible = [incomp.text for incomp in incompatible] if incompatible is not None else []
                
            mod_list.append(Mod(id, name, list(set(hard_dependencies) | set(load_after) | set(incompatible)), list(set(load_before) | set(incompatible))))
    except FileNotFoundError:
        print("Mod folder not found1")
        return None
    except NotADirectoryError:
        print("Mod folder not found2")
        return None
    return [mod for mod in mod_list if mod.id in active_mods]