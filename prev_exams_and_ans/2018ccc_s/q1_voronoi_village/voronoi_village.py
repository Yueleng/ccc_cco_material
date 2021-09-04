N = int(input())
villages = []
for i in range(N):
    villages.append(int(input()))

villages = sorted(villages)

min = pow(2, 31) - 1
for i in range(1, N-1):
    left = (villages[i] - villages[i-1]) / 2
    right = (villages[i+1] - villages[i]) / 2
    if left+right <= min:
        min = left+right

print(min)
