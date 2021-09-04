from collections import deque

# n = int(input())
# m = int(input())


class Point:
    def __init__(self, x, y):
        self.x = x
        self.y = y


def cameraBfs(cam):
    for p in cam:
        r = p.x
        c = p.y
        for k in range(4):
            t = 1
            while True:
                nr = r + t * d[k][0]
                nc = c + t * d[k][1]
                if g[nr][nc] == 'W':
                    break
                if g[nr][nc] == '.' or g[nr][nc] == 'S':
                    vis[nr][nc] = True
                t += 1


def bfs(stx, sty):
    if not vis[stx][sty]:
        q.append(Point(stx, sty))
        dis[stx][sty] = 0
    else:
        return

    while len(q) > 0:
        p = q.popleft()
        r = p.x
        c = p.y
        # if dis[r][c] > 0:  # already visited before
        #     continue
        if g[r][c] == '.' or g[r][c] == 'S':
            for k in range(4):
                nr = r + d[k][0]
                nc = c + d[k][1]
                push(dis[r][c] + 1, nr, nc)
        elif g[r][c] == 'L':
            push(dis[r][c] + 1, r, c-1)
        elif g[r][c] == 'R':
            push(dis[r][c] + 1, r, c+1)
        elif g[r][c] == 'U':
            push(dis[r][c] + 1, r-1, c)
        elif g[r][c] == 'D':
            push(dis[r][c] + 1, r+1, c)
        # for p in q:
        #     print(str(p.x) + ' ' + str(p.y))
        # print("---")


def push(dis_value, r, c):
    if g[r][c] != 'W' and vis[r][c] == False and dis[r][c] == -100:
        q.append(Point(r, c))
        if g[r][c] == '.':
            dis[r][c] = dis_value
        else:
            dis[r][c] = dis_value - 1


n, m = list(map(int, input().split()))
g = [['' for i in range(m+1)] for j in range(n+1)]
d = [[-1, 0], [1, 0], [0, -1], [0, 1]]  # up, down, left, right
vis = [[False for i in range(m+1)] for j in range(n+1)]
dis = [[-100 for i in range(m+1)] for j in range(n+1)]
cam = []
q = deque()

st = Point(1, 1)

for i in range(1, n+1):
    s = input()
    for j in range(1, m+1):
        g[i][j] = s[j - 1]
        if g[i][j] == 'S':
            st = Point(i, j)
        if g[i][j] == 'C':
            cam.append(Point(i, j))

cameraBfs(cam)
bfs(st.x, st.y)

# for arr in g:
#     print(arr)

# for arr in vis:
#     print(arr)

for i in range(1, n+1):
    for j in range(1, m+1):
        if g[i][j] == '.':
            print(dis[i][j] if dis[i][j] != -100 else -1)
