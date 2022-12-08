data = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
for i in range(14,len(data)):
    print(data[(i-14):i])
    for x in data[(i-14):i]:
        if data[(i-14):i].count(x) > 1:
            break;
    else:
        print(i)
        break;
