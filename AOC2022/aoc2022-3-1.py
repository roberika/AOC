data = ["vJrwpWtwJgWrhcsFMMfFFhFp",
"jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
"PmmdzqPrVvPwwTWBwg",
"wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
"ttgJtRGJQctTZtZT",
"CrZsJsPPZsGzwwsLwLmpwMDw"]
t = 0
for x in range(len(data)):
    for y in data[x][0:int(len(data[x])/2)]:
        if (y in data[x][int(len(data[x])/2):len(data[x])]):
            if y in "abcdefghijklmnopqrstuvwxyz":
                t += ord(y)-96
            else:
                t += ord(y)-64+26
            break
print(t)








