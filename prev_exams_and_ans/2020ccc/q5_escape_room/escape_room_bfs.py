# this file is an improvement of escape_room_slow.py
# def next(pos, is_visited_before):
#     nexts = []
#     num = grid[pos[0]][pos[1]]
#     for i in range(1, row+1):
#         for j in range(1, col+1):
#             if (num == i * j and not (str(i) + "," + str(j)) in is_visited_before):
#                 nexts.append((i,j))
#                 is_visited_before.add(str(i) + "," + str(j))
#     return nexts

# This solution does not pass full batches in time.

from collections import deque
from collections import defaultdict
def next(pos):
    num = grid[pos[0]][pos[1]]
    if num in int_decompose:
        for (i,j) in int_decompose[num]:
            # if (str(i) + "," + str(j)) not in is_visited_before:
            if is_visited_before[i][j] == False:
                tries.append((i,j))
                is_visited_before[i][j] = True
    

row = int(input())
col = int(input())

grid = [[0 for _ in range(col + 1)] for _ in range(row + 1)]

# int_decompose = {num1: [(a,b), (c,d)], num2: [(e,f)], ...}
int_decompose = defaultdict(list)

# read data into grid and create int_decompose
for i in range(1, row + 1):
    grid[i] = [0] + [int(x) for x in input().split()]
    for j in range(1, col + 1):
        if i * j in int_decompose:
            int_decompose[i * j].append((i,j))
        else:
            # create new entry for this dictionary
            int_decompose[i*j] = [(i,j)]
        # print(int_decompose)


# queue: tries
# tries = []
tries = deque()
# is_visited_before = set()
is_visited_before = [[False for _ in range(col + 1)] for _ in range(row + 1)]

tries.append((1, 1))
# is_visited_before.add("1,1")
is_visited_before[1][1] = True

found = False
while (len(tries) > 0):
    # (i, j) = tries.pop(0)
    (i,j) = tries.popleft()
    # print(i,j)
    if (i == row and j == col):
        found = True
        print("yes")
        break
    # tries += next((i,j))
    next((i,j))
    # for pos in next((i,j)):
    #     tries.append(pos)

if not found:
    print("no")