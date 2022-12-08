data = ["30373",
"25512",
"65332",
"33549",
"35390"]

trees = []
total = 0
for x in data:
  trees.append([int(tree) for tree in x])
print(trees)
for r in range(len(trees)):
  for c in range(len(trees[r])):
    
    for up in range(r):
      if trees[up][c] >= trees[r][c]:
        break;
    else:
      total += 1
      continue;
    
    for down in range(len(trees)-1-r):
      if trees[r+down+1][c] >= trees[r][c]:
        break;
    else:
      total += 1
      continue;
    
    for left in range(c):
      if trees[r][left] >= trees[r][c]:
        break;
    else:
      total += 1
      continue;
    
    for right in range(len(trees[r])-1-c):
      if trees[r][c+right+1] >= trees[r][c]:
        break;
    else:
      total += 1
      continue;
print(total)
            
