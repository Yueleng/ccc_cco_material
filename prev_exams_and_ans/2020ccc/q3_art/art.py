# Topic: geometry; 2d array;

import sys
input = sys.stdin.readline

lines = int(input())

left_bound = 101
lower_bound = 101
right_bound = -1
upper_bound = -1

for i in range(0, lines):
    point = [int(x) for x in input().split(",")]
    if (point[0] <= left_bound): # note less or equal
        left_bound = point[0] - 1
    if (point[0] >= right_bound):
        right_bound = point[0] + 1
    if (point[1] <= lower_bound):
        lower_bound = point[1] - 1
    if (point[1] >= upper_bound):
        upper_bound = point[1] + 1
    
print(str(left_bound) + "," + str(lower_bound))
print(str(right_bound) + "," + str(upper_bound))