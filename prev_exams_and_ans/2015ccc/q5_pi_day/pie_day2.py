n = int(input())
k = int(input())

max_pie = n - (k-1)

pies = list(range(1, max_pie+1))

pi_memo = [[[0 for i in range(k + 1)] for j in range(n + 1)] for k in range(len(pies)+1)]


def count(pies, len, pie_left, people_left):
    if len < 0 or pie_left < 0 or people_left < 0:
        return 0
    if pi_memo[len][pie_left][people_left] == 0:
        
        if pie_left == 0 and people_left == 0:
            pi_memo[len][pie_left][people_left] = 1
            return pi_memo[len][pie_left][people_left]
            # return 1
        if pie_left == 0 and people_left > 0:
            return 0

        if pie_left < 0:
            return 0
        if len <= 0 and pie_left >= 0:
            return 0
        pi_memo[len][pie_left][people_left] = count(pies[1:], len-1, pie_left, people_left) + count(pies, len, pie_left-pies[0], people_left - 1)
    return pi_memo[len][pie_left][people_left]
    # return count(pies[1:], len-1, pie_left, people_left) + count(pies, len, pie_left-pies[0], people_left - 1)

print(count(pies, len(pies), n, k))