values = [1,2,3,4,5]

newValues = [1,2,3,4,5]
for i in range(len(values) ): # 1 plus
    newValues[i] +=1 # add to new values
    print("old value at index {} is {}".format(i, values[i])) # values
    print("new value at index {} is {}\n".format(i, newValues[i]))

print(newValues)