#import sys
#input = sys.stdin.readline

grid = [[1,2],[3,4]]
instructions = input()
for i in instructions:
    if i == "H":
        leftUp = grid[0][0]
        rightUp = grid[0][1]
        grid[0][0] = grid[1][0]
        grid[0][1] = grid[1][1]
        grid[1][0] = leftUp
        grid[1][1] = rightUp
    else:
        leftUp = grid[0][0]
        leftDown = grid[1][0]
        grid[0][0] = grid[0][1]
        grid[1][0] = grid[1][1]
        grid[0][1] = leftUp
        grid[1][1] = leftDown

print(grid[0][0], grid[0][1])
print(grid[1][0], grid[1][1])