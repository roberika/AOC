data = ["30373",
"25512",
"65332",
"33549",
"35390"]

trees = []
top = 0
for x in data:
  trees.append([int(tree) for tree in x])
print(trees)
for r in range(len(trees)):
  for c in range(len(trees[r])):
    total = 1

    tree = 0
    for up in range(r):
      tree += 1
      if trees[r-1-up][c] >= trees[r][c]:
        break;
    total *= tree

    tree = 0
    for down in range(len(trees)-1-r):
      tree += 1
      if trees[r+down+1][c] >= trees[r][c]:
        break;
    total *= tree
    
    tree = 0
    for left in range(c):
      tree += 1
      if trees[r][c-1-left] >= trees[r][c]:
        break;
    total *= tree

    tree = 0
    for right in range(len(trees[r])-1-c):
      tree += 1
      if trees[r][c+right+1] >= trees[r][c]:
        break;
    total *= tree

    if top < total:
      top = total
print(top)
            
