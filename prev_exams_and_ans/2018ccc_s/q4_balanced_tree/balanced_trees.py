from collections import defaultdict


dp = defaultdict(int)


def func(n):
    if n == 1 or n == 2:
        return 1
    if n in dp:
        return dp[n]

    fin = 0
    k = n

    while k >= 2:
        # k: upper bound branches
        # e.g.: n = 100, k = 100, x = 1, nn = 50, fin += (100 - 50) * func(1)
        #  next n = 100, k = 50, x = 2, nn = 33, fin += (50 - 33) * func(2)
        #  ...
        x = int(n / k)
        # nn: lower bound branches
        nn = int(n / (x + 1))
        # func(2) = 1, k - nn = 1
        fin += (k - nn) * func(x)
        k = nn

    dp[n] = fin
    return fin


N = int(input())
print(func(N))
