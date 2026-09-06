class Mod:
    def __init__(self, id, name, dependencies = [], loadafter = [], loadbefore = [], incompatible = []):
        self.id = id
        self.name = name
        self.dependencies = dependencies
        self.load_after = loadafter
        self.load_before= loadbefore
        self.incompatible = incompatible
    def to_string(self):
        print(self.id, self.name, "AAAAAAAA")
        if self.dependencies is not None:
            for dependency in self.dependencies:
                print(dependency)
        if self.load_after is not None:
            for loadafter in self.load_after:
                print(loadafter)
        if self.load_before is not None:
            for loadbefore in self.load_before:
                print(loadbefore)
        if self.incompatible is not None:
            for incompat in self.incompatible:
                print (incompat)
        