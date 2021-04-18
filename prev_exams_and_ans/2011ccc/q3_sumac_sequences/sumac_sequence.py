import sys
input = sys.stdin.readline
num1 = int(input())
num2 = int(input())

def sumac_count(num1, num2):
    if (num1 < num2):
        return 2
    return 1 + sumac_count(num2, num1 - num2)

print(sumac_count(num1, num2))