# Introduction to Lists
zoo_animals = ["pangolin", "cassowary", "sloth", 'lion'];

if len(zoo_animals) > 3:
	print "The first animal at the zoo is the " + zoo_animals[0]
	print "The second animal at the zoo is the " + zoo_animals[1]
	print "The third animal at the zoo is the " + zoo_animals[2]
	print "The fourth animal at the zoo is the " + zoo_animals[3]



# Access by Index
numbers = [5, 6, 7, 8]

print "Adding the numbers at indices 0 and 2..."
print numbers[0] + numbers[2]
print "Adding the numbers at indices 1 and 3..."
print numbers[1] + numbers[3]



# New Neighbors
zoo_animals = ["pangolin", "cassowary", "sloth", "tiger"]
zoo_animals[2] = "hyena"
zoo_animals[3] = "lion"



# Late Arrivals & List Length
suitcase = [] 
suitcase.append("sunglasses")
suitcase.append("tie")
suitcase.append("watch")
suitcase.append("shoes")

list_length = len(suitcase)

print "There are %d items in the suitcase." % (list_length)
print suitcase



# List Slicing
suitcase = ["sunglasses", "hat", "passport", "laptop", "suit", "shoes"]

first  = suitcase[0:2]
middle = suitcase[2:4]
last   = suitcase[4:6]



# Slicing Lists and Strings
animals = "catdogfrog"
cat  = animals[:3]
dog  = animals[3:6]
frog = animals[6:]



# Maintaining Order
animals = ["aardvark", "badger", "duck", "emu", "fennec fox"]
duck_index = animals.index("duck")

animals.insert(duck_index, "cobra")

print animals



# For One and All
my_list = [1,9,3,8,5,7]

for number in my_list:
    print 2 * number



# Mor with 'for'
start_list = [5, 3, 1, 2, 4]
square_list = []

for number in start_list:
    square_list.append(number ** 2)

square_list.sort()
print square_list



# This Next Part is Key
residents = {'Puffin' : 104, 'Sloth' : 105, 'Burmese Python' : 106}

print residents['Puffin'] 
print residents['Sloth']
print residents['Burmese Python']



# New Entries
menu = {}
menu['Chicken Alfredo'] = 14.50
print menu['Chicken Alfredo']

menu['Hambuger'] = 5.85
menu['coffee'] = 1.99
menu['candy'] = 0.50

print "There are " + str(len(menu)) + " items on the menu."
print menu



# Changing Your Mind
zoo_animals = { 
	'Unicorn' : 'Cotton Candy House',
	'Sloth' : 'Rainforest Exhibit',
	'Bengal Tiger' : 'Jungle House',
	'Atlantic Puffin' : 'Arctic Exhibit',
	'Rockhopper Penguin' : 'Arctic Exhibit'
}

del zoo_animals['Unicorn']
del zoo_animals['Sloth']
del zoo_animals['Bengal Tiger']

zoo_animals['Rockhopper Penguin'] = "Ice House"

print zoo_animals



# Remove a Few Things
backpack = ['xylophone', 'dagger', 'tent', 'bread loaf']
backpack.remove('dagger')



# It's Dangerous to Go Alone! Take This
inventory = {
    'gold' : 500,
    'pouch' : ['flint', 'twine', 'gemstone'],
    'backpack' : ['xylophone','dagger', 'bedroll','bread loaf']
}

inventory['burlap bag'] = ['apple', 'small ruby', 'three-toed sloth']
inventory['pouch'].sort() 

inventory['pocket'] = ['seashell', 'strange berry', 'lint']
inventory['backpack'].sort()
inventory['backpack'].remove('dagger')
inventory['gold'] = inventory['gold'] + 50