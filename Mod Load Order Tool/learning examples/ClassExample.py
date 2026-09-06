class Person:
	def __init__(self, name, age):
		self.name = name
		self.age = age

	def introduce(self):
		return f"My name is {self.name} and I am {self.age} years old."

    
# Instantiate one object from the class.
person = Person("Andy", 30)
print(person.introduce())
