data = [
    ]
st = 0
for x in data:
    s = 0
    if(x[2] == "X"):
        s += 0
        if(x[0] == "A"):
            s += 3
        elif(x[0] == "B"):
            s += 1
        else:
            s += 2
    elif(x[2] == "Y"):
        s += 3
        if(x[0] == "A"):
            s += 1
        elif(x[0] == "B"):
            s += 2
        else:
            s += 3
    else:
        s += 6
        if(x[0] == "A"):
            s += 2
        elif(x[0] == "B"):
            s += 3
        else:
            s += 1
    st += s
print(st)
            
