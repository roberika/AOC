data = ["Sabqponm",
"abcryxxl",
"accszExk",
"acctuvwj",
"abdefghi"]



import sys
import random
print(sys.getrecursionlimit())
sys.setrecursionlimit(1500)

results = [2000]
path = []
S = [0,0]
E = [0,0]
queue = []

def explore(x,y,i):
##    if tooTired(i):
##        #print("L")
##        return
    if x == S[0] and y == S[1]:
        queue.clear()
        results.append(i)
        results.sort()
        print(results[0:2])
        return
    queue.append([x,y,x+1,y,i])
    queue.append([x,y,x-1,y,i])
    queue.append([x,y,x,y+1,i])
    queue.append([x,y,x,y-1,i])
    #queue.sort(key=lambda queue:queue[4])
def walk(x1,y1,x2,y2,i):
    if ((inMap(x2,y2)) and (not beenVisited(x2,y2)) and (not tooLow(x1,y1,x2,y2))):
        #visitMap()
        visit[x2+y2*(len(path[0]))] = True
        explore(x2,y2,i+1)
def inMap(x,y):
    return y > -1 and y < len(path) and x > -1 and x < len(path[0])
def tooLow(x1,y1,x2,y2):
    return path[y1][x1]-1 > path[y2][x2]
def tooTired(i):
    return i > results[0]
def beenVisited(x,y):
    return visit[x+y*(len(path[0]))]
def visitMap():
    s = ""
    for i,x in enumerate(visit):
        if i % int(len(path[0])) == 0:
            s += "\n"
        if x:
            s += "T"
        else:
            s += "F"
    print(s,"\n")

for r,x in enumerate(data):
    line = []
    for c,char in enumerate(list(x)):
        if char == 'S':
            line.append(ord('a')-97)
            S[0] = c
            S[1] = r
            print("S")
        elif char == 'E':
            line.append(ord('z')-97)
            E[0] = c
            E[1] = r
            print("E")
        else:
            line.append(ord(char)-97)
    path.append(line)
#print(emptyVisit)
visit = [ (E[0] == int(v%len(path[0])) and E[1] == int(v/len(path[0]))) for v in range(len(path)*len(path[0]))]

explore(E[0],E[1],0)
while len(queue) > 0:
    points = queue.pop(0)
    if len(queue) % 21 == 0:
        visitMap()
    walk(points[0],points[1],points[2],points[3],points[4])
visitMap()
for x in results:
    print(x)
print(results[0])
i = 0
for x in visit:
    if x:
        i+=1
print(i)
