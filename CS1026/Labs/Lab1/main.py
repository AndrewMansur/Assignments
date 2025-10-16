# ----- QUESTION 1 ----- 
answer1 = 5 + 3
answer2 = 7*4
print("answer1")
print(answer1)

# ----- QUESTION 2 ----- 
x = 7
print(x)
y = x + 5
print(f"\nx is {x} and y is {y}")
print("x is %d and y is %d" % (x,y))

# ----- QUESTION 3 ----- 
shopName = input("\nPlease enter the shop name: ")
ringQTY = int(input("Please enter ring QTY: "))
glassesQTY = int(input("Please enter glasses QTY: "))

print("Shop name is {}".format(shopName))
print("Ring QTY is {}".format(ringQTY))
print("Glasses QTY is {}".format(glassesQTY))

print("\nInventory Total: {}".format(ringQTY + glassesQTY))
