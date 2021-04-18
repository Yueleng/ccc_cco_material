import math

n = int(input())

def is_nasty(num):
    summ = []
    diff = []
    for d in range(1, int(math.sqrt(num) + 1)):
        if num % d == 0:
            summ.append(d + int(num / d))
            diff.append(int(num / d) - d)

    i = 0; j = 0
    while (i < len(summ) and j < len(diff)):
        if (summ[i] == diff[j]):
            return True
        elif (summ[i] < diff[j]):
            j += 1
        else:
            i += 1
    return False

for i in range(0, n):
    num = int(input())
    if is_nasty(num):
        print(str(num) + " is nasty")
    else:
        print(str(num) + " is not nasty")



