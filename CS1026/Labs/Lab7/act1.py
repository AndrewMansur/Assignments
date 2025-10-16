values = [1,2,3,4,5,"hello",6,7,8,9,"10"]

for cur in values:
    print("The Value is :", values[cur])
    if type(values[cur]) == str:
        raise ValueError("This is a string")

        