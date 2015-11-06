# Function Junction
def spam():
    """Prints 'Eggs!' to the console."""
    print "Eggs!"

spam()



# Call and Response
def square(n):
    """Returns the square of a number."""
    squared = n**2
    print "%d squared is %d." % (n, squared)
    return squared

square(10)



# Parameters and Arguments
def power(base, exponent):
    result = base**exponent
    print "%d to the power of %d is %d." % (base, exponent, result)

power(37, 4)



# Functions Calling Functions
def one_good_turn(n):
    return n + 1
    
def deserves_another(n):
    return one_good_turn(n) + 2



# Practice Makes Perfect
def cube(number):
    return number * number * number
    
def by_three(number):
    if number % 3 == 0:
        return cube(number)
    else:
        return False

print by_three(3)



# I Know Kung Fu
print sqrt(25)



# Generic Imports
import math
print math.sqrt(25)



# Function Imports
from math import sqrt



# Universal Imports
from math import *



# max()
maximum = max(1, 2, 3)

print maximum



# min()
minimum = min(1, 2, 3)

print minimum



# abs()
absolute = abs(-42)

print absolute



# type()
print type(10)
print type(2.5)
print type('dudmy')



# Review: Functions
def shut_down(s):
    if s == 'yes':
        return "Shutting down"
    elif s == 'no':
        return "Shutdown aborted"
    else:
        return "Sorry"



# Review: Modules
from math import sqrt
print sqrt(13689)



# Review: Built-In Functions
def distance_from_zero(n):
    if type(n) == int or type(n) == float:
        return abs(n)
    else:
        return "Nope"