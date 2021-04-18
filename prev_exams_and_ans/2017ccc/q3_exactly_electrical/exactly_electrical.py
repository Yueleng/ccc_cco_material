import sys
input = sys.stdin.readline

start = [int(x) for x in input().split()]
end = [int(x) for x in input().split()]

t = int(input())

hori_diff = abs(start[0] - end[0])
vert_diff = abs(start[1] - end[1])

if ( t >= hori_diff + vert_diff and 
    (hori_diff + vert_diff - t) % 2 == 0):
    print("Y")
else:
    print("N")