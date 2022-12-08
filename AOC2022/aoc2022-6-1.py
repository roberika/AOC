data = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
for i in range(4,len(data)):
    print(data[(i-4):i])
    for x in data[(i-4):i]:
        if data[(i-4):i].count(x) > 1:
            break;
    else:
        print(i)
        break;
