# Defining placeholders for variables
totalPreviousYear = 0
totalYearInterest = 0
inflationType = ""

# Prompting user input on the year and number of categories
year = int(input("Please enter the year that you want to calculate the personal interest rate for: "))
expenditureCategories = int(input("Please enter the number of expenditure categories: "))

# Iterating through and adding the expenses for previous year and year of interest. Iterating through number of categories times
for i in range(0, expenditureCategories):
    expensesPreviousYear = float(input("Please enter expenses for previous year: "))
    expensesYearInterest = float(input("Please enter expenses for year of interest: "))

    # Adding to the total expenses 
    totalPreviousYear += expensesPreviousYear
    totalYearInterest += expensesYearInterest

# Calculating the total inflation rate 
inflationRate = ((totalYearInterest - totalPreviousYear) / totalYearInterest) * 100

# Checking and comparing the inflationType
if inflationRate < 3:
    inflationType = "Low"
elif inflationRate >= 3 and inflationRate < 5:
    inflationType = "Moderate"
elif inflationRate >= 5 and inflationRate < 10:
    inflationType = "High"
else:
    inflationType = "Hyper"

# Printing final results of inflation rate for the year chosen and type of inflation
print(f"Personal inflation rate for {year} is {inflationRate}%")
print(f"Type of Inflation: {inflationType}")

