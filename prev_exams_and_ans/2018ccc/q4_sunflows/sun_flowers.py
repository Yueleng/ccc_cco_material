def transback_from(degree, grid):
    N = len(grid)
    rotated_grid = [[0 for x in range(0, N)] for y in range(0, N)]
		
    if degree == "positive_90":
        for x in range(0, N):
            for y in range(0, N):
                rotated_grid[N-1-y][x] = grid[x][y]
    elif degree == "diagonal":
        for x in range(0, N):
            for y in range(0, N):
                rotated_grid[N-1-x][N-1-y] = grid[x][y]
    elif degree == "negative_90":
        for x in range(0, N):
            for y in range(0, N):
                rotated_grid[y][N-1-x] = grid[x][y]
    else: 
        return grid

    return rotated_grid


def determine_degree(grid):
    N = len(grid)
    if (grid[0][N-1] < grid[0][N-2] and grid[0][N-1] < grid[1][N-1]):
        return "positive_90"
    elif (grid[N-1][N-1] < grid[N-1][N-2] and grid[N-1][N-1] < grid[N-2][N-1]):
        return "diagonal"
    elif (grid[N-1][0] < grid[N-2][0] and grid[N-1][0] < grid[N-1][1]):
        return "negative_90"
    
    return "zero";


N = int(input())

grid = []

for i in range(0, N):
    grid.append([int(x) for x in input().split()])

grid = transback_from(determine_degree(grid), grid)

for i in range(0, N):
    for j in range(0, N):
        print(grid[i][j], "", end="")
    print()
