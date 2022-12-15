data = ["498,4 -> 498,6 -> 496,6",
"503,4 -> 502,4 -> 502,9 -> 494,9"]

maxy = 0

def draw(text):
    global maxy
    points = [[int(xy) for xy in point.split(",")] for point in text.split(" -> ")]
    for i in range(len(points)-1):
        xd = abs(points[i][0]-points[i+1][0])
        if xd != 0:
            for x in range(xd+1):
                room[points[i][1]][x+min(points[i][0],points[i+1][0])-300] = True
        yd = abs(points[i][1]-points[i+1][1])
        if yd != 0:
            for y in range(yd+1):
                room[y+min(points[i][1],points[i+1][1])][points[i][0]-300] = True
        if points[i][1] > maxy:
            maxy = points[i][1]
def simulate(x,y):
    if y+1 == len(room):
        return True
    if not isFilled(x,y+1):
        return simulate(x,y+1)
    if not isFilled(x-1,y+1):
        return simulate(x-1,y+1)
    if not isFilled(x+1,y+1):
        return simulate(x+1,y+1)
    room[y][x] = True
    return False
def isFilled(x,y):
    return room[y][x]

room = [[False for x in range(400)] for y in range(200)]
before = 0
after = 0
for x in data:
    draw(x)
for i in range(len(room[0])):
    room[maxy+2][i] = True
        
screen = ""
for y in room:
    string = ""
    for x in y:
        if x:
            string += ("# ")
            before += 1
        else:
            string += (". ")
    screen += string + "\n"
print(screen)
print()

while not room[0][200]:
    simulate(200,0)

screen = ""
for y in room:
    string = ""
    for x in y:
        if x:
            string += ("# ")
            after += 1
        else:
            string += (". ")
    screen += string + "\n"
print(screen)


print(before,after,after-before)


