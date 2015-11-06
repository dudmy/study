# Ahoy! (or Should I Say Ahoyay!)
print "Pig Latin"



# Input!
print 'Welcome to the Pig Latin Translator!'

original = raw_input("Enter a word:")



# Check Yourself!
print 'Welcome to the Pig Latin Translator!'

# Start coding here!
original = raw_input("Enter a word:")

if len(original) > 0:
    print original
else:
    print "empty"



# Check Yourself... Some More
print 'Welcome to the Pig Latin Translator!'

# Start coding here!
original = raw_input("Enter a word:")

if original.isalpha():
    print original
else:
    print "empty"



# Ay B C
pyg = 'ay'



# Word Up
pyg = 'ay'

original = raw_input('Enter a word:')

if len(original) > 0 and original.isalpha():
    word = original.lower()
    first = word[0]
    print first
else:
    print 'empty'



# Move it on Back
pyg = 'ay'

original = raw_input('Enter a word:')

if len(original) > 0 and original.isalpha():
    word = original.lower()
    first = word[0]
    new_word = word + first + pyg
    print new_word
else:
    print 'empty'



# Ending Up
pyg = 'ay'

original = raw_input('Enter a word:')

if len(original) > 0 and original.isalpha():
    word = original.lower()
    first = word[0]
    new_word = word + first + pyg
    new_word = new_word[1:]
    print new_word
else:
    print 'empty'