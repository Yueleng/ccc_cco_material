N, T = list(map(int, input().split()))
curr_state = [int(char) for char in input()]
next_state = [0 for i in range(N)]

for i in range(T):
    # one-gen evolve
    for i in range(N):
        j = (i - 1) % N
        k = (i + 1) % N

        # exactly one of the hell's neighbor is alive
        if curr_state[j] + curr_state[k] == 1:
            next_state[i] = 1
        else:
            next_state[i] = 0

    # copy next_state to curr_state
    curr_state = next_state[:]

print("".join([str(c) for c in next_state]))
