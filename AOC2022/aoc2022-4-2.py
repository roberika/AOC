data = ["2-4,6-8",
"2-3,4-5",
"5-7,7-9",
"2-8,3-7",
"6-6,4-6",
"2-6,4-8"]

t = 0
for x in data:
    pair1 = x.split(",")[0]
    pair2 = x.split(",")[1]
    sec1 = int(pair1.split("-")[0])
    sec2 = int(pair1.split("-")[1])
    sec3 = int(pair2.split("-")[0])
    sec4 = int(pair2.split("-")[1])
    if(sec1 >= sec3 and sec2 <= sec4):
        t += 1
    elif(sec1 <= sec3 and sec2 >= sec4):
        t += 1
    elif(sec1 >= sec3 and sec1 <= sec4):
        t += 1
    elif(sec2 >= sec3 and sec2 <= sec4):
        t += 1
    elif(sec3 >= sec1 and sec3 <= sec2):
        t += 1
    elif(sec4 >= sec1 and sec4 <= sec2):
        t += 1
print(t)
