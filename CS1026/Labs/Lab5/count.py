def match_words(words):
    counter = 0

    for word in words:
        if len(word) > 1 and word[0] == word[-1]:
            counter += 1
    return counter

print(match_words(['abc', 'xyz', 'aba', '1221']))