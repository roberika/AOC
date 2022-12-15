data = ["R 4",
"U 4",
"L 3",
"D 1",
"R 4",
"D 1",
"L 5",
"R 2"]

r = 0
l = 0
d = 0
u = 0
h = 0
v = 0
for x in data:
    step = int(x[2:4])
    if x[0] == "R":
        h += step
        if h > r:
            r = h
    elif x[0] == "L":
        h -= step
        if h < l:
            l = h
    elif x[0] == "D":
        v -= step
        if v < d:
            d = v
    else:
        v += step
        if v > u:
            u = v
h = (r-l+5)*1
v = (u-d+5)*1

trail = []
for r in range(v):
    temp = []
    for c in range(h):
        temp.append(False)
    trail.append(temp);
sh = (d*-1+2)*1
sv = (l*-1+2)*1
rope = [
    [sh,sv],
    [sh,sv],
    [sh,sv],
    [sh,sv],
    [sh,sv],
    [sh,sv],
    [sh,sv],
    [sh,sv],
    [sh,sv],
    [sh,sv]]
trail[sh][sv] = True
print(r,l,u,d,h,v)

def follow(front,back):
    if abs(front[0] - back[0]) > 1 or abs(front[1] - back[1]) > 1:
        if front[0] > back[0]:
            back[0] += 1
        elif front[0] < back[0]:
            back[0] -= 1        
        if front[1] > back[1]:
            back[1] += 1
        elif front[1] < back[1]:
            back[1] -= 1
    #print()
        
    
def step(step, horizontal, vertical):
    for i in range(step):
        rope[0][0] += vertical
        rope[0][1] += horizontal
        for j in range(len(rope)-1):
            follow(rope[j],rope[j+1])
        trail[rope[0][0]][rope[0][1]] = True
        #screen()
        #print(rope[0][0],rope[0][1])

def screen():
    scr = ""
    for r in range(v):
        s = ""
        for c in range(h):
            if r == rope[0][0] and c == rope[0][1]:
                s += "H"
            elif trail[r][c]:
                s += "#"
            else:
                for i in range(1,10):
                    if r == rope[i][0] and c == rope[i][1]:
                        s += str(i)
                        break;
                else:
                    s += "."
        scr += s + "\n"
    print(scr)

for x in data:
    #print(x)
    repetition = int(x[2:4])
    if x[0] == "R":
        step(repetition,1,0)
    elif x[0] == "L":
        step(repetition,-1,0)
    elif x[0] == "D":
        step(repetition,0,-1)
    else:
        step(repetition,0,1)

total = 0
for r in range(v):
    for c in range(h):
        if trail[r][c]:
            total += 1
screen()
print(total)


























