from abc import ABC, abstractmethod
from pathlib import Path
from core.ModClass import Mod

class GameModParser(ABC):
    @abstractmethod
    def scan_mods_folder(self, game_path: Path) -> list[Mod]:
        """access description file from mods and create an array of data"""
        pass