def pop(heap):
    popped = heap[0]
    heap[0] = heap[-1]
    heap.pop()
    lq = len(heap)
    node = 0
    while node < lq:
        minimum = heap[node]
        nxt_node = node
        l_node = node*2+1
        r_node = node*2+2
        if l_node < lq and heap[l_node] < minimum:
            minimum = heap[l_node]
            nxt_node = l_node
        if r_node < lq and heap[r_node] < minimum:
            minimum = heap[r_node]
            nxt_node = r_node
        if node != nxt_node:
            heap[node], heap[nxt_node] = heap[nxt_node], heap[node]
            node = nxt_node
        else:
            node = lq
    return popped


def push(heap, item):
    heap.append(item)
    lq = len(heap)
    node = lq-1
    while node > 0:
        nxt_node = (node-1)//2
        if heap[nxt_node] > heap[node]:
            heap[node], heap[nxt_node] = heap[nxt_node], heap[node]
            node = nxt_node
        else:
            node = 0




# Read K, N, M from file
# K: Convex-hull thickness
# N: how many points, how many vertices
# M: how many routes, how many edges


# map(f, arr) -> for every element e in arr, we return f(e) and put back to arr
# input().split(" ") -> ["10", "4", "7"];
# map(int, ["10", "4", "7"]) -> [10, 4, 7]
K, N, M = map(int, input().split(" "))

# every element in routes is a dictionary
# representation of the graph.
routes = [{} for n in range(N)]
for m in range(M): # for (m = 0; m < M; m++)
    # every loop sets append (t,h) to 
    # routes[a-1][b-1] & routes[b-1][a-1]
    # a: start island, b: arriving island, t: edge length, h: wear amount
    a, b, t, h = map(int, input().split())

    # routes[a-1] -> {}
    # {}.setdefault(b-1,[]) -> ({} -> {b-1, []}) return []
    # [].append((t,h)) -> [(t,h)]
    # (t,h) # tuple
    routes[a-1].setdefault(b-1, []).append((t, h)) # a-1: {b-1: [(t,h)]}
    routes[b-1].setdefault(a-1, []).append((t, h))
    # api: routes[a][b] -> [(t,h)]

# infinity to be large
INF = 10**10

# read the starting point to ending point
# starting point:p, ending point:q
p, q = map(int, input().split())
p, q = p-1, q-1

min_time = INF

distance = [INF for n in range(N)]

distance[p] = 0
visited = set()
que = [(0, p, K)]

while que:
    island = pop(que)
    if island[1] == q:
        min_time = island[0]
        break
    if island[1] in visited:
        continue
    visited.add(island[1])

    # all the neighbors of island[1]
    for destination in routes[island[1]]:
        # routes[island[1]][destination] only returns one element
        for route in routes[island[1]][destination]:
            # route: (t_i, h_i)
            # distance[island[1]]： new distance to a new destination
            # destination: new destination
            # island[2] - route[1]: thickness left
            to_add = (distance[island[1]] + route[0], destination, island[2] - route[1])
            # only if to_add[2] greater than 0, otherwise skip
            if to_add[2] > 0:
                if to_add[0] < distance[to_add[1]]:
                    distance[to_add[1]] = to_add[0]
                push(que, to_add)
if min_time == INF:
    min_time = -1

print(min_time)