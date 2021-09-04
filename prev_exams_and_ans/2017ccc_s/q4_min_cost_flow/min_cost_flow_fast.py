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

    if a == b: return

    if sz[a] < sz[b]:
        id[a] = b
        sz[b] += sz[a]
    else:
        id[b] = a
        sz[a] += sz[b]

def mst():
    num_of_days = 0
    cnt = 0
    lgst_w = 0
    i = 0
    for ed in edges:
        if cnt == n-1:
            break
        if root(ed.u) != root(ed.v):
            lgst_w = ed.w
            if ed.qu >= n:
                num_of_days += 1
            merge(ed.u, ed.v)
            cnt += 1
        i += 1
    return num_of_days, lgst_w, i-1

# Cat1: ed.w < lgst_w; Cat2: ed.w == lgst_w and ed.qu <= n-1
# Cat3: ed.w == lgst_w and ed.qu >= n; Cat4: ed.w > lgst_w
# 
# Q: How do you know that of those edges from cat4 
#    that can be added into the spanning tree formed by cat1+cat2
#    will replace one edge from cat3
# A: Based on cat1 + cat2, any one edge added from cat4(satisfying ed.qu <= n-1 and ed.w <= d) 
#    and we stop the search and added back the remaining edges from cat3, thus must create a loop of edges 
#    that is due to the adding of cat3 edge. Since previous MST formed by (cat1+cat2+ partof cat3) does not have any 
#    loop, thus the loop created must due to one edge from cat4 and this edge can be exchangable with one edge from cat3
#    DONE!
def days_reducer(num_of_days, lgst_w):
    cnt = 0
    for ed in edges:
        if root(ed.u) != root(ed.v):
            if cnt == n-1:
                break
            if ed.w < lgst_w or (ed.w == lgst_w and ed.qu <= n-1):
                merge(ed.u, ed.v)
                cnt += 1
            elif ed.qu <= n - 1 and ed.w <= d:
                num_of_days -= 1
                break
    return num_of_days

n, m, d = [int(x) for x in input().split()]
id = [i for i in range(n+1)]
sz = [1 for i in range(n+1)]
edges = []

for i in range(m):
    a,b,c = [int(x) for x in input().split()]
    edges.append(ed(a,b,c,i+1))

# for e in edges:
#     print(e.u, e.v, e.w, e.qu, "original")

edges.sort(key=cmp_to_key(cmp))

# for e in edges:
#     print(e.u, e.v, e.w, e.qu, "sorted")

num_of_days, lgst_w, current_idx = mst()

id = [i for i in range(n+1)]

if edges[current_idx].qu <= n-1: # last edge in MST from existing valid plan, no need to run days_reducer
    print(num_of_days)
else:
    num_of_days = days_reducer(num_of_days, lgst_w)
    print(num_of_days)