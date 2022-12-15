data = ["[1,1,3,1,1]",
"[1,1,5,1,1]",
"",
"[[1],[2,3,4]]",
"[[1],4]",
"",
"[9]",
"[[8,7,6]]",
"",
"[[4,4],4,4]",
"[[4,4],4,4,4]",
"",
"[7,7,7,7]",
"[7,7,7]",
"",
"[]",
"[3]",
"",
"[[[]]]",
"[[]]",
"",
"[1,[2,[3,[4,[5,6,7]]]],8,9]",
"[1,[2,[3,[4,[5,6,0]]]],8,9]"]

def compare(a,b):
    if isinstance(a,int):
        if isinstance(b,int):
            if a == b:
                return 1
            if a < b:
                return 2
            return 0
        else:
            return compare([a],b)
    else:
        if isinstance(b,int):
            return compare(a,[b])
        else:
            if len(a) == 0 and len(b) == 0:
                return 1
            if len(a) == 0:
                return 2
            if len(b) == 0:
                return 0
            if compare(a[0],b[0]) == 1:
                #print(a[1:].copy(),b[1:].copy(),"\n")
                return compare(a[1:].copy(),b[1:].copy())
            return compare(a[0],b[0])

packets = []                

total = 1
ordered = [0 for i in range(int((len(data)/3))+1)]
for i in range(len(data)):
    if data[i] != "":
        packets.append(eval(data[i]))
packets.append([[2]]) 
packets.append([[6]])
for i in range(len(packets)-1):
    for j in range(len(packets)-i-1):
        if compare(packets[j],packets[j+1]) == 2:
            temp = packets.pop(j)
            packets.insert(j+1,temp)
packets.reverse()
for i in range(len(packets)):
    print(packets[i])
    if packets[i] == [[2]] or packets[i] == [[6]]:
        print("ping")
        total *= (i+1)
print(total)










