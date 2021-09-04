n = int(input())

swifts = [int(s) for s in input().split()]
semaphores = [int(s) for s in input().split()]

def sum_of_arr(arr, stop_idx):
    sum = 0
    for i in range(stop_idx+1):
        sum += arr[i]
    return sum
    

k = 0
for i in range(len(swifts)):
    if sum_of_arr(swifts, i) == sum_of_arr(semaphores, i):
        k = i + 1

print(k)
