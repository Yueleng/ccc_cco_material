from collections import defaultdict


def sums(i, j):
    return sz[j] - sz[i-1]


N = int(input())
dp = [[False for i in range(N+1)] for j in range(N+1)]
sz = [0 for i in range(N+1)]

rice_balls = list(map(int, input().split()))

for i in range(1, N+1):
    sz[i] = rice_balls[i-1] + sz[i-1]

ans = 0
for gap in range(N):
    for i in range(1, N+1):
        j = i + gap

        if j > N:
            continue

        dp[i][j] = False

        if j == i:
            dp[i][j] = True
        elif j - i <= 2:
            if sums(i, i) == sums(j, j):
                dp[i][j] = True

        # for k in range(i, j):  # i <= k <= j - 1
        #     if sums(i, k) > sums(k+1, j):
        #         break
        #     if dp[i][k] and dp[k+1][j] and sums(i, k) == sums(k+1, j):
        #         dp[i][j] = True
        #         break
        #     if dp[i][k] and k+2 <= j and dp[k+2][j] and sums(i, k) == sums(k+2, j):
        #         dp[i][j] = True
        #         break
        #     if
        k = i
        l = j  # i <= k < l <= j
        while (k < l):
            if k == l - 1 and dp[i][k] and dp[l][j] and sums(i, k) == sums(l, j):
                dp[i][j] = True
                break
            if dp[i][k] and dp[l][j] and dp[k+1][l-1] and sums(i, k) == sums(l, j):
                dp[i][j] = True
                break
            if sums(i, k) < sums(l, j):
                k += 1
            else:
                l -= 1

        # size_idx = defaultdict(int)
        # for k in range(i, j): # i <= k <= j-1
        #     if dp[i][k]:
        #         size_idx[sums(i,k)] = k

        # for l in range(i+1, j+1): # i+1 <= l <= j
        #     if dp[l][j]:
        #         if (sums(l,j) in size_idx and size_idx[sums(l,j)] <= l-1):
        #             if (size_idx[sums(l,j)] == l-1):
        #                 dp[i][j] = True
        #             else:
        #                 left = size_idx[sums(l,j)] + 1
        #                 right = l - 1
        #                 if dp[left][right]:
        #                     dp[i][j] = True

        if dp[i][j]:
            ans = max(ans, sums(i, j))

print(ans)
