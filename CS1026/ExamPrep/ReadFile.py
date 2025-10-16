letters = {}
file = open("text.txt", "r") # see file from from Q2
for line in file:
    line = line.strip()
    print(line[0])