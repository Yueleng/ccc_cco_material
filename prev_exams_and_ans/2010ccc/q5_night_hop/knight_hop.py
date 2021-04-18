def finished(state):
    return state[1] == final_pos

def inside_bound(state):
    return state[1][0] <= 8 and state[1][0] >= 1 and state[1][1] <= 8 and state[1][1] >= 1

def next(state):
    for move in moves:
        next_state = [state[0] + 1, [state[1][0] + move[0], state[1][1] + move[1]]]
        if inside_bound(next_state) and not is_visited_before[next_state[1][0]][next_state[1][1]]:
            tries.append(next_state)
            is_visited_before[next_state[1][0]][next_state[1][1]] = True


from collections import deque

start_pos = [int(x) for x in input().split()]
start_state = [0, start_pos]
final_pos = [int(x) for x in input().split()]

# Initilize tries, is_visited_before
tries = deque()
is_visited_before = [[False for _ in range(9)] for _ in range(9)]
tries.append(start_state)
is_visited_before[start_state[1][0]][start_state[1][1]] = True

moves = [[1, 2], [2, 1], [2, -1], [1, -2], [-1, -2], [-2, -1], [-2, 1], [-1, 2]]

while (len(tries) > 0):
    next_state = tries.popleft()
    if finished(next_state):
        print(next_state[0])
        break
    next(next_state)
