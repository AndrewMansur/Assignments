def zFirst(words):
    zresult = []
    result =[]
    for word in words:
        if word.lower()[0] == "z":
            zresult.append(word)
        else:
            result.append(word)
    
    zresult.sort()
    result.sort()
    return zresult + result

words = ["hello", "zebra", "bob", "yes", "zoo"]
print(zFirst(words))


