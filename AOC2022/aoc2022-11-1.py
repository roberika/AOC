data = ["Monkey 0:",
"  Starting items: 79, 98",
"  Operation: new = old * 19",
"  Test: divisible by 23",
"    If true: throw to monkey 2",
"    If false: throw to monkey 3",
"",
"Monkey 1:",
"  Starting items: 54, 65, 75, 74",
"  Operation: new = old + 6",
"  Test: divisible by 19",
"    If true: throw to monkey 2",
"    If false: throw to monkey 0",
"",
"Monkey 2:",
"  Starting items: 79, 60, 97",
"  Operation: new = old * old",
"  Test: divisible by 13",
"    If true: throw to monkey 1",
"    If false: throw to monkey 3",
"",
"Monkey 3:",
"  Starting items: 74",
"  Operation: new = old + 3",
"  Test: divisible by 17",
"    If true: throw to monkey 0",
"    If false: throw to monkey 1"]

monkeys = []


for i,x in enumerate(data):
    match(i % 7):
        case 0:
            items = []
            operation = ""
            test = -1
            true = -1
            false = -1
            print(i)
        case 1:
            items = [int(y) for y in x[18:].split(", ")]
        case 2:
            operation = x[19:]
        case 3:
            test = int(x[21:])
        case 4:
            true = int(x[29:])
        case 5:
            false = int(x[30:])
            monkeys.append([items,operation,test,true,false,0])
for x in monkeys:
    print(x)
for i in range(20):
    for x in monkeys:
        for item in x[0]:
            x[5] += 1
            old = item
            new = eval(x[1])
            new = int(new / 3)
            if new % x[2] == 0:
                monkeys[x[3]][0].append(new)
            else:
                monkeys[x[4]][0].append(new)
        x[0].clear()
    print()
    for x in monkeys:
        print(x)
max1 = 0
max2 = 0
monkeys.reverse()
for x in monkeys:
    if x[5] > max2:
        if x[5] > max1:
            max2 = max1
            max1 = x[5]
        else:
            max2 = x[5]
print(max2*max1)
















        
