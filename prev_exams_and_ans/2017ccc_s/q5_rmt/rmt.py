import math

# ib[line][position]: which block
# ibx[line][position]: passenger count
# lix[line][block index]: last position in ib[x] for 'block index'
# passenger[index]: position in the line

# construct data structure for usage


def build():
    # blcoksize <- sqrt(n)
    if blocksize == 1:
        p = 1
        blockindex = 1
        pblock = 1
        while p <= n:
            sp = station[p]
            blocksum[blockindex] += passenger[p]
            if blockindex == ib[sp][-1]:
                ib[sp].append(blockindex)
                ibx[sp].append(passenger[p])
                passenger[p] = len(ib[sp]) - 1
            else:
                ib[sp].append(blockindex)
                ibx[sp].append(passenger[p])
                lix[sp].append(len(ib[sp]) - 2)
                passenger[p] = len(ib[sp]) - 1
            p += 1
            pblock += 1

            if pblock > blocksize:
                pblock = 1
                blockindex += 1
    else:
        p = 1
        blockindex = 0
        while p <= n:
            if p % blocksize == 1:
                blockindex += 1
            sp = station[p]  # sp means line number
            blocksum[blockindex] += passenger[p]
            if blockindex == ib[sp][-1]:
                ib[sp].append(blockindex)
                ibx[sp].append(passenger[p])
                passenger[p] = len(ib[sp]) - 1
            else:
                ib[sp].append(blockindex)
                ibx[sp].append(passenger[p])
                lix[sp].append(len(ib[sp]) - 2)
                passenger[p] = len(ib[sp]) - 1
            p += 1

# query summatin from l to u.


def query(l, u):
    # c: starting block index
    c = int(l / blocksize)

    # end block index
    d = int(u / blocksize)
    if u % blocksize != 0:
        d += 1

    total = 0

    # get total from starting block to end block (inclusive)
    for i in range(c, d+1):
        total += blocksum[i]

    # try to deduct extra passenger
    cons = max(1, (c-1) * blocksize + 1)

    # cut the head
    for i in range(l-1, cons-1, -1):  # starting from [cons, l-1].
        line = station[i]
        # get the shifted index
        indexforit = passenger[i] - shift[line]
        if indexforit <= 0:
            indexforit += len(ibx[line])-1

        total -= ibx[line][indexforit]

    # cut the tail
    if (u % blocksize != 0):
        cons = min(n, d*blocksize)
        for i in range(u+1, cons+1):  # [u+1, cons]
            line = station[i]
            indexforit = passenger[i] - shift[line]
            if indexforit <= 0:
                indexforit += len(ibx[line]) - 1
            total -= ibx[line][indexforit]
    return total

# operate side effect


def update(x):
    # x: line x
    # loop through lix[x],
    # lix[x] stores last occurency indices for every block that line x covers
    for i in range(len(lix[x])):
        # pi: for block i, pi means the last indice that block i appears in ib[x]
        # if pi == 0, consider as last block's last occurency indices, i.e. len(ib[x]) - 1
        pi = lix[x][i]
        if pi == 0:
            pi = len(ib[x]) - 1
        p2 = pi - shift[x]  # how much has been shifted for pi
        if p2 <= 0:
            p2 += len(ib[x]) - 1
        p3 = pi + 1
        if p3 >= len(ib[x]):
            p3 = 1

        # next block: plus
        # current block: minus
        blocksum[ib[x][p3]] += ibx[x][p2]
        blocksum[ib[x][pi]] -= ibx[x][p2]
    # shift to next
    shift[x] += 1
    shift[x] %= len(ib[x]) - 1


passenger = []
n, m, q = [int(x) for x in input().split()]
blocksize = int(math.sqrt(n))
station = [0 for i in range(n+1)]
passenger = [0 for i in range(n+1)]
shift = [0 for i in range(m+1)]
blocksum = [0 for i in range(blocksize+3)]
ib = [0 for i in range(m+1)]
ibx = [0 for i in range(m+1)]
lix = [0 for i in range(m+1)]

station[1:] = [int(x) for x in input().split()]
# print(station)

passenger[1:] = [int(x) for x in input().split()]

for i in range(m+1):
    ib[i] = []
    ib[i].append(-1)
    ibx[i] = []
    ibx[i].append(-1)
    lix[i] = []

build()
print("blocksum: ", blocksum)
print("ib: ", ib)
print("ibx: ", ibx)
print("lix: ", lix)
print("passenger: ", passenger)

for i in range(q):
    info = input().split()
    if info[0] == '1':
        print(query(int(info[1]), int(info[2])))
    else:
        update(int(info[1]))
