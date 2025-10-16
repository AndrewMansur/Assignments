f = open("text.txt", "r")
positive = []
neutral = []
negative = []

for line in f:
    entries = line.split(",")
    entries[1] = int(entries[1].rstrip("\n"))
    if entries[1] == 20:
        positive.append(entries[0])
    elif entries[1] == 0:
        neutral.append(entries[0])
    else:
        negative.append(entries[0])

tweet = "I really am very happy for you I love the weather I am also sad and have some regrets about being so tired"
    
tweetwords = tweet.split()
sentiment = 0
for word in tweetwords:
    if word in positive:
        sentiment +=20
    elif word in negative:
        sentiment -= 10

print(f"The positive keywords are {positive}")
print(f"the neutral keywords are {neutral}")
print(f"The negative keywords are {negative}")
print(f"The sentiment of the tweet is {sentiment}")

f.close()