class p:
    def __init__(self, x, y):
        self.x = x
        self.y = y

def init_order():
    order.append(p(2, 2))
    order.append(p(2, 1))
    order.append(p(2, 3))
    order.append(p(1, 2))
    order.append(p(3, 2))


def fillR(r, cnt):
    if v[r][1]:
        a[r][1] = 2 * a[r][2] - a[r][3]
        col[1] -= 1
        v[r][1] = False

    if v[r][3]:
        a[r][3] = 2 * a[r][2] - a[r][1]
        col[3] -= 1
        v[r][3] = False

    if v[r][2]:
        a[r][2] = int((a[r][1] + a[r][3]) / 2)
        col[2] -= 1
        v[r][2] = False

    row[r] -= 1
    return cnt - 1


def fillC(c, cnt):
    if v[1][c]:
        a[1][c] = 2 * a[2][c] - a[3][c]
        row[1] -= 1
        v[1][c] = False

    if v[3][c]:
        a[3][c] = 2 * a[2][c] - a[1][c]
        row[3] -= 1
        v[3][c] = False

    if v[2][c]:
        a[2][c] = int((a[1][c] + a[3][c]) / 2)
        row[2] -= 1
        v[2][c] = False

    col[c] -= 1
    return cnt - 1


def fillCell(r, c, cnt):
    row[r] -= 1
    col[c] -= 1
    v[r][c] = False
    a[r][c] = 0
    return cnt - 1


if __name__ == "__main__":
            
    a = [[0, 0, 0, 0] for i in range(4)]
    v = [[False, False, False, False] for i in range(4)]
    row = [0, 0, 0, 0]
    col = [0, 0, 0, 0]
    cnt = 0
    order = []

    # execute only if run as a script
    init_order()

    for i in range(1, 4):
        j = 1
        for x in input().split(' '):
            if x == "X":
                v[i][j] = True
                row[i] += 1
                col[j] += 1
                cnt += 1
            else:
                a[i][j] = int(x)
            j += 1

    while cnt > 0:
        
        ok = False
        for i in range(1, 4):
            if row[i] == 1:
                # print("fill r ", i)
                cnt = fillR(i, cnt)
                ok = True
                break
        if ok:
            continue
        for i in range(1, 4):
            if col[i] == 1:
                # print("fill c ", i)
                cnt = fillC(i, cnt)
                ok = True
                break
        if ok:
            continue
        for p in order:
            if v[p.x][p.y]:
                # print("fill cell  ", p.x, " ", p.y)
                cnt = fillCell(p.x, p.y, cnt)
                ok = True
                break
        if ok:
            continue
        for i in range(1, 4):
            for j in range(1, 4):
                if v[i][j]:
                    # print("fill cell ", i, " ", j)
                    cnt = fillCell(i, j, cnt)
                    ok = True
                    break
            if ok:
                break
                
    for i in range(1, 4):
        for j in range(1, 4):
            print(a[i][j], end=" ")
        print()
