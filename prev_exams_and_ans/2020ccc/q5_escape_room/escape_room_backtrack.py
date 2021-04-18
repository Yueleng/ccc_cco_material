M = int(input())
N = int(input())

jump_map = {}
for i in range(M):
  vals = input().split()  
  for j in range(N):
    number = int(vals[j])
    if i==0 and j==0:
      start = number
    if number in jump_map.keys():
        jump_map[number].append((i+1)*(j+1))
    else:
        jump_map[number] = [ (i+1)*(j+1) ]

prev_layer = {M*N}
canEscape = False
visited = {M*N}

while prev_layer:
  new_layer = set()
  if start in prev_layer:
    canEscape = True
    break
  for m in prev_layer:
    if m in jump_map.keys():
      for number in jump_map[m]:
        if not number in visited:
          new_layer.add(number)
          visited.add(number)
  if len(new_layer) == 0:
    break
  prev_layer = new_layer

if canEscape:
  print("yes")
else:
  print("no")