from collections import deque

def is_finished(state):
    for i in range(0, len(state[1])):
        if state[1][i] == "" or int(state[1][i]) != i + 1:
            return False
    return True

def next(state):
    for i in range(0, len(state[1])):
        for j in range(i-1, i+2, 1):
            if j < len(state[1]) and j >= 0:
                slot_i = state[1][i]
                slot_j = state[1][j]
                if slot_j != "":
                    if (slot_i != "" and slot_j[-1] < slot_i[-1]) or (slot_i == ""):
                        slot_i += slot_j[-1]
                        slot_j = slot_j[:-1]
                        new_pos = state[1].copy()
                        new_pos[i] = slot_i
                        new_pos[j] = slot_j
                        if ','.join(new_pos) not in visited:
                            tries.append([state[0] + 1, new_pos])
                            visited.add(','.join(new_pos))


while True:
    n = int(input())
    if n == 0:
        break

    found = False
    visited = set()
    tries = deque()
    init_pos = [x for x in input().split()]

    init_state = [0, init_pos]

    if is_finished(init_state):
        print(init_state[0])
        found = True
        continue
    
    tries.append(init_state)
    visited.add(','.join(init_state[1]))

    while (len(tries) > 0):
        curr_state = tries.popleft()
        if is_finished(curr_state):
            print(curr_state[0])
            found = True
            break

        next(curr_state)

    if not found:
        print("IMPOSSIBLE")
