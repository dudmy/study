# Before We Begin
def answer():
    return 42



# Planning Your Trip
def hotel_cost(nights):
    return 140 * nights



# Getting There
def hotel_cost(nights):
    return 140 * nights

def plane_ride_cost(city):
    if city == "Charlotte":
        return 183
    elif city == "Tampa":
        return 220
    elif city == "Pittsburgh":
        return 222
    elif city == "Los Angeles":
        return 475



# Transportation
def hotel_cost(nights):
    return 140 * nights

def plane_ride_cost(city):
    if city == "Charlotte":
        return 183
    elif city == "Tampa":
        return 220
    elif city == "Pittsburgh":
        return 222
    elif city == "Los Angeles":
        return 475
        
def rental_car_cost(days):
    costs = 40 * days
    if days >= 7:
        costs -= 50
    elif days >= 3:
        costs -= 20
    return costs



# Pull it Together
def hotel_cost(nights):
    return 140 * nights

def plane_ride_cost(city):
    if city == "Charlotte":
        return 183
    elif city == "Tampa":
        return 220
    elif city == "Pittsburgh":
        return 222
    elif city == "Los Angeles":
        return 475
        
def rental_car_cost(days):
    costs = 40 * days
    if days >= 7:
        costs -= 50
    elif days >= 3:
        costs -= 20
    return costs

def trip_cost(city, days):
    return hotel_cost(days) + plane_ride_cost(city) + rental_car_cost(days)



# Hey, You Never Know!
def hotel_cost(nights):
    return 140 * nights

def plane_ride_cost(city):
    if city == "Charlotte":
        return 183
    elif city == "Tampa":
        return 220
    elif city == "Pittsburgh":
        return 222
    elif city == "Los Angeles":
        return 475
        
def rental_car_cost(days):
    costs = 40 * days
    if days >= 7:
        costs -= 50
    elif days >= 3:
        costs -= 20
    return costs

def trip_cost(city, days, spending_money):
    return hotel_cost(days) + plane_ride_cost(city) + rental_car_cost(days) + spending_money



# Plan Your Trip!
def hotel_cost(nights):
    return 140 * nights

def plane_ride_cost(city):
    if city == "Charlotte":
        return 183
    elif city == "Tampa":
        return 220
    elif city == "Pittsburgh":
        return 222
    elif city == "Los Angeles":
        return 475
        
def rental_car_cost(days):
    costs = 40 * days
    if days >= 7:
        costs -= 50
    elif days >= 3:
        costs -= 20
    return costs

def trip_cost(city, days, spending_money):
    return hotel_cost(days) + plane_ride_cost(city) + rental_car_cost(days) + spending_money

print trip_cost("Los Angeles", 5, 600)