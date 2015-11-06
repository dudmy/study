# The Meal
meal = 44.50



# The Tax
meal = 44.50
tax = 6.75/100



# The Tip
meal = 44.50
tax = 0.0675
tip = 0.15



# Reassign in a Single Line
meal = 44.50
tax = 0.0675
tip = 0.15

meal = meal + meal * tax



# The Total
meal = 44.50
tax = 0.0675
tip = 0.15

meal = meal + meal * tax
total = meal + meal * tip

print("%.2f" % total)