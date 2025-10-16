file = open("text.txt", "r")
for i in range(3):
    line = file.readline() # Readline will read each next new line for every time its called

line = file.readline()
print(line)