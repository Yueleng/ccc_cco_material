n = int(input())

swifts = [int(s) for s in input().split()]
semaphores = [int(s) for s in input().split()]

k = 0
sum_to_i_swifts = 0
sum_to_i_semaphores = 0
for i in range(len(swifts)):
    sum_to_i_swifts += swifts[i]
    sum_to_i_semaphores += semaphores[i]
    if sum_to_i_swifts == sum_to_i_semaphores:
        k = i + 1

print(k)
