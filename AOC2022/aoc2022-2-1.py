data = [
    ]
st = 0
for x in data:
    s = 0
    if(x[2] == "X"):
        s += 1
        if(x[0] == "A"):
            s += 3
        elif(x[0] == "B"):
            s += 0
        else:
            s += 6
    elif(x[2] == "Y"):
        s += 2
        if(x[0] == "A"):
            s += 6
        elif(x[0] == "B"):
            s += 3
        else:
            s += 0
    else:
        s += 3
        if(x[0] == "A"):
            s += 0
        elif(x[0] == "B"):
            s += 6
        else:
            s += 3
    st += s
print(st)
            
