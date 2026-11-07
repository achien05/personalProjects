for number in range(1, 11):
	print(number)

# Loop through a list
fruits = ["apple", "banana", "cherry"]
for fruit in fruits:
	print(fruit)

# Loop with an index
for index, fruit in enumerate(fruits):
	print(index, fruit)

# While loop
count = 1
while count <= 3:
	print(count)
	count += 1

# Nested loops
for row in range(2):
	for column in range(3):
		print(row, column)

# Loop with continue and break
for number in range(1, 11):
	if number % 2 == 0:
		continue
	if number > 7:
		break
	print(number)
