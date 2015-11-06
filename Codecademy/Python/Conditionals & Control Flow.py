# Compare Closely!
# Set this to True if 17 < 328 or to False if it is not.
bool_one = True   # We did this one for you!

# Set this to True if 100 == (2 * 50) or to False otherwise.
bool_two = True

# Set this to True if 19 <= 19 or to False if it is not.
bool_three = True

# Set this to True if -22 >= -18 or to False if it is not.
bool_four = False

# Set this to True if 99 != (98 + 1) or to False otherwise.
bool_five = False



# Compare... Closelier!
# (20 - 10) > 15
bool_one = False    # We did this one for you!

# (10 + 17) == 3**16
# Remember that ** can be read as 'to the power of'. 3**16 is about 43 million.
bool_two = False

# 1**2 <= -1
bool_three = False

# 40 * 4 >= -4
bool_four = True

# 100 != 10**2
bool_five = False



# How the Tables Have Turned
# Make me true!
bool_one = 3 < 5  # We already did this one for you!

# Make me false!
bool_two = 5 <= 2

# Make me true!
bool_three = 3 == 3

# Make me false!
bool_four = 2 != (1 + 1)

# Make me true!
bool_five = 100 >= 100



# And
bool_one = False

bool_two = False

bool_three = False

bool_four = True

bool_five = True



# Or
bool_one = True

bool_two = True

bool_three = False

bool_four = True

bool_five = False



# Not
bool_one = False

bool_two = True

bool_three = True

bool_four = True

bool_five = False



# This and That (or This, But Not That!)
bool_one = False

bool_two = True

bool_three = True

bool_four = True

bool_five = False



# Mix 'n' Match
# Make me false!
bool_one = (2 <= 2) and "Alpha" == "Bravo"  # We did this one for you!

# Make me true!
bool_two = True and False or True

# Make me false!
bool_three = (2 == 3) or False

# Make me true!
bool_four = (5 >= 1) and True 

# Make me true!
bool_five = 'Yujin' == 'yujin' or True



# Conditional Statement Syntax
response = "Y"

answer = "Left"
if answer == "Left":
    print "This is the Verbal Abuse Room, you heap of parrot droppings!"



# If You're Having...
def using_control_once():
    if 2 == 2:
        return "Success #1"

def using_control_again():
    if 5 >= 1:
        return "Success #2"

print using_control_once()
print using_control_again()



# Else Problems, I Feel Bad for You, Son...
answer = "'Tis but a scratch!"

def black_knight():
    if answer == "'Tis but a scratch!":
        return True
    else:             
        return False       # Make sure this returns False

def french_soldier():
    if answer == "Go away, or I shall taunt you a second time!":
        return True
    else:             
        return False       # Make sure this returns False



# I Got 99 Problems, But a Switch Ain't One
def greater_less_equal_5(answer):
	if answer > 5:
		return 1
	elif answer < 5:
		return -1
	else:
		return 0

print greater_less_equal_5(4)
print greater_less_equal_5(5)
print greater_less_equal_5(6)



# The Big If
def the_flying_circus():
	if 2 == 2:
		return True
	elif 2 < 1:
		return False

print the_flying_circus()