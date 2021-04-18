import sys
input = sys.stdin.readline

distance = [int(s) for s in input().split()]

for i in range(0, len(distance) + 1):
    for j in range(0, len(distance) + 1):
        # note that sum([]) = 0 which satifies our expectation.
        print(sum(distance[i:j]) if i < j else sum(distance[j:i]), " ", end='')
    print()
    