import sys
input = sys.stdin.readline

def find_shortest_cycle(diff):
    cycle_len = 1
    if (len(diff) == 0): 
        return 0

    if (len(diff) == 1):
        return 1

    while (True): 
        flag = True
        for i in range(0, len(diff)):
            if (diff[i % cycle_len] == diff[i]):
                continue
            flag = False
            break
        if (flag):
            return cycle_len
        else: 
            cycle_len += 1

while (True):
    averages = [int(s) for s in input().split()]
    if averages[0] == 0: break
    averages = averages[1:]
    diff = []
    for i in range(1, len(averages)):
        diff.append(averages[i] - averages[i-1])
    # print(diff)
    print(find_shortest_cycle(diff))