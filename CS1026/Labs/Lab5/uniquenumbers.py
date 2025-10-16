List = []

while len(List) != 10:
    n = int(input("Enter the value: "))
    if not n in List:
        List.append(n)

print(List)