def next(pos, is_visited_before):
    nexts = []
    num = grid[pos[0]][pos[1]]
    for i in range(1, row+1):
        for j in range(1, col+1):
            if (num == i * j and not (str(i) + "," + str(j)) in is_visited_before):
                nexts.append((i,j))
                is_visited_before.add(str(i) + "," + str(j))
    return nexts

row = int(input())
col = int(input())

grid = [[0 for _ in range(col + 1)] for _ in range(row + 1)]

# read data into grid
for i in range(1, row + 1):
    grid[i] = [0] + [int(x) for x in input().split()]

# queue: tries
tries = []
is_visited_before = set()

tries.append((1, 1))
is_visited_before.add("1,1")

found = False
while (len(tries) > 0):
    (i, j) = tries.pop(0)
    # print(i,j)
    if (i == row and j == col):
        found = True
        print("yes")
        break

    tries += next((i,j), is_visited_before)

if not found:
    print("no")