from functools import cmp_to_key
class ed:
  def __init__(self, u, v, w, qu):
    self.u = u
    self.v = v
    self.w = w
    self.qu = qu

def cmp(ed1, ed2):
    if ed1.w == ed2.w:
        return ed1.qu - ed2.qu
    else:
        return ed1.w - ed2.w

def root(i):
    while (i != id[i]):
        id[i] = id[id[i]]
        i = id[i]
    return i

def merge(p, q):
    a = root(p)
    b = root(q)
    id[a] = b

def mst():
    num_of_days = 0
    cnt = 0
    lgst_w = 0
    for ed in edges:
        if cnt == n - 1:
            break
        if root(ed.u) != root(ed.v):
            lgst_w = ed.w
            if ed.qu >= n:
                num_of_days += 1
            merge(ed.u, ed.v)
            cnt += 1
    return num_of_days, lgst_w

def mst_reducer(num_of_days, lgst_w):
    for ed in edges:
        if root(ed.u) != root(ed.v):
            if ed.w < lgst_w or (ed.w == lgst_w and ed.qu <= n-1):
                merge(ed.u, ed.v)
            elif ed.qu <= n - 1 and ed.w <= d:
                num_of_days -= 1
                break
    return num_of_days

n, m, d = [int(x) for x in input().split()]
id = [i for i in range(n+1)]
edges = []

for i in range(m):
    a,b,c = [int(x) for x in input().split()]
    edges.append(ed(a,b,c,i+1))

# for e in edges:
#     print(e.u, e.v, e.w, e.qu, "original")

edges = sorted(edges, key=cmp_to_key(cmp))

# for e in edges:
#     print(e.u, e.v, e.w, e.qu, "sorted")

num_of_days, lgst_w = mst()

id = [i for i in range(n+1)]

num_of_days = mst_reducer(num_of_days, lgst_w)

print(num_of_days)