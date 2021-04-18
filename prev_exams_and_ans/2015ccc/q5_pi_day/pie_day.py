n = int(input())
k = int(input())

pi_memo = [[[0 for i in range(n + 1)] for j in range(k + 1)] for k in range(n+1)]

def pi(left_pi, left_person, min_pi, pi_cache):
    if pi_cache[left_pi][left_person][min_pi] == 0:
        if (left_pi == left_person and min_pi == 1) or (left_person == 1):
            pi_cache[left_pi][left_person][min_pi] = 1
        else:
            sum = 0
            for j in range(min_pi, int(left_pi/left_person)+1):
                sum += pi(left_pi-j, left_person-1, j, pi_cache)
            pi_cache[left_pi][left_person][min_pi] = sum
    return pi_cache[left_pi][left_person][min_pi]

print(pi(n, k, 1, pi_memo))