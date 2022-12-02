data = [
  ]
elf = [x for x in data if x == 0]
print(len(elf))
e = 0
c = 0
for x in data:
  if(x == 0):
    elf[e] = c
    c = 0
    e = e+1
    continue
  c = c + x
elf.sort()
print(elf[len(elf)-1]+elf[len(elf)-2]+elf[len(elf)-3])





