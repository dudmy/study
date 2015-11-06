# Strings
brian = "Hello life!"


# Practice
caesar = "Graham"
praline = "John"
viking = "Teresa"

print caesar
print praline
print viking


# Escaping characters
'This isn\'t flying, this is falling with style!'


# Access by Index
fifth_letter = "MONTY"[4]

print fifth_letter


# String methods
parrot = "Norwegian Blue"

print len(parrot)


# lower()
parrot = "Norwegian Blue"

print parrot.lower()


# upper()
parrot = "norwegian blue"

print parrot.upper()


# str()
pi = 3.14
print str(pi)


# Dot Notation
ministry = "The Ministry of Silly Walks"

print len(ministry)
print ministry.upper()


# Printing Strings
print "Monty Python"



# Printing Variables
the_machine_goes = "Ping!"
print the_machine_goes



# String Concatenation
print "Spam " + "and " + "eggs"



# Explicit String Conversion
print "The value of pi is around " + str(3.14)



# String Formatting with %, Part 2
name = raw_input("What is your name?")
quest = raw_input("What is your quest?")
color = raw_input("What is your favorite color?")

print "Ah, so your name is %s, your quest is %s, " \
"and your favorite color is %s." % (name, quest, color)



# And Now, For Something Completely Familiar
my_string = "dudmy"
print len(my_string)
print my_string.upper()