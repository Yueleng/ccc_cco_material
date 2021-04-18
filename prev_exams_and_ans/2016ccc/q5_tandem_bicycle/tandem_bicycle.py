import sys
input = sys.stdin.readline
max_min_indicator = int(input())
N = int(input()) # useless

dmo = [int(x) for x in input().split()]
peg = [int(x) for x in input().split()]

dmo.sort()
peg.sort()

def max_spd(arr1, arr2):
    sum = 0
    arr_len = len(arr1)
    for i in range(0, arr_len):
        sum += max(arr1[i], arr2[arr_len-1-i])
    return sum

def min_spd(arr1, arr2):
    sum = 0
    arr_len = len(arr1)
    for i in range(0, arr_len):
        sum += max(arr1[i], arr2[i])
    return sum

print(max_spd(dmo, peg) if max_min_indicator == 2 else min_spd(dmo, peg))