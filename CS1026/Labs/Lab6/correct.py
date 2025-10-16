text = open("ye.txt", "r")
myfile = open("myfile.txt", "w") # need  w
line = text.readline() # need brackets
words = list(line)

for word in words:
    print(word) # dont need \n
    myfile.write(word + "\n") # need to add \n

text.close()
myfile.close()