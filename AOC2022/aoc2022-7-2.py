data = ["$ cd /",
"$ ls",
"dir a",
"14848514 b.txt",
"8504156 c.dat",
"dir d",
"$ cd a",
"$ ls",
"dir e",
"29116 f",
"2557 g",
"62596 h.lst",
"$ cd e",
"$ ls",
"584 i",
"$ cd ..",
"$ cd ..",
"$ cd d",
"$ ls",
"4060174 j",
"8033020 d.log",
"5626152 d.ext",
"7214296 k",
        "$"]

def keyFunc(e):
  return e[0]

trail = []
total = 99999999999
directories = [[-1,["/"]]]
start = -1
tab = -1
for i in range(len(data)):
  if data[i][0] == "$":
    if start != -1:
      for x in directories:
        if x[1] == trail:
          targetDirectory = x
          break
      for j in range(i-start):
        tempDirectory = []
        tempTrail = trail.copy()
        tempTrail.append(data[start+j][4:len(data[start+j])])
        if data[start+j][0:3] == "dir":
          tempDirectory.append(tab)
          tempDirectory.append(tempTrail)
          directories.append(tempDirectory)
          targetDirectory.append(tempDirectory)
        else:
          tempDirectory.append(int(data[start+j].split(" ")[0]))
          tempDirectory.append(data[start+j].split(" ")[1])
          targetDirectory.append(tempDirectory)
      start = -1
    if data[i][5:7] == "..":
      trail.pop()
      tab -= -1
    elif data[i][2:3] == "l":
      start = i+1
    else:
      trail.append(data[i][5:len(data[i])])
      tab += -1

directories.sort(key=keyFunc,reverse=False)
for x in directories:
  size = 0
  for i in range(len(x)-2):
    if x[i+2][0] > 0:
      size += x[i+2][0]
  x[0] = size

directories.sort(key=keyFunc,reverse=True)
for x in directories:
  size = x[0]
  print(size)
  if 70000000-directories[0][0]+size >= 30000000:
    if total > size:
      total = size
      print("\n\n\n")
      
print(total)

    








  
