data = [
[],
["Z","N"],
["M","C","D"],
["P"]
  ]

ins = [
"move 1 from 2 to 1",
"move 3 from 1 to 3",
"move 2 from 2 to 1",
"move 1 from 1 to 2"
  ]

for x in ins:
  y = x.split(" ")
  many = int(y[1])
  fro = int(y[3])
  to = int(y[5])
  lis = []
  for i in range(many):
    lis.append(data[fro].pop())
  for i in range(many):
    data[to].append(lis.pop())
for x in data:
  print(x)
