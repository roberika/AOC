data = ["vJrwpWtwJgWrhcsFMMfFFhFp",
"jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
"PmmdzqPrVvPwwTWBwg",
"wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
"ttgJtRGJQctTZtZT",
"CrZsJsPPZsGzwwsLwLmpwMDw"]
t = 0
for x in range(0,len(data),3):
    for y in data[x]:
        if (y in data[x+1] and y in data[x+2]):
            if y in "abcdefghijklmnopqrstuvwxyz":
                t += ord(y)-96
            else:
                t += ord(y)-64+26
            break
print(t)








