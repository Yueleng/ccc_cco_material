import sys


def highest_power_of_2(n):
    if (n < 1):
        return 0
    res = 1
    # Try all powers starting from 2^1
    for i in range(8 * sys.getsizeof(n)):
        curr = 1 << i

        # If current power is more than n, break
        if (curr > n):
            break

        res = curr

    return res


N, T = list(map(int, input().split()))
curr_state = [int(char) for char in input()]
next_T_state = [0 for i in range(N)]

# one-gen evolve
while T > 0:
    d = highest_power_of_2(T)
    for i in range(N):
        j = (i - d) % N
        k = (i + d) % N

        # exactly one of the cell's neighbor is alive
        if curr_state[j] + curr_state[k] == 1:
            next_T_state[i] = 1
        else:
            next_T_state[i] = 0
    T -= d
    curr_state = next_T_state[:]
    # print(d)
    # print("".join([str(c) for c in next_T_state]))

print("".join([str(c) for c in next_T_state]))
