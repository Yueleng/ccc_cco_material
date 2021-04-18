import math
start = int(input())
end = int(input())

def is_rsa(num):
    cnt = 0
    for i in range(1, int(math.sqrt(num)) + 1):
        if num % i == 0 and i * i != num:
            cnt += 2
        elif i * i == num:
            cnt += 1
            
    return cnt == 4

sum = 0
for i in range(start, end+1):
    if is_rsa(i):
        sum += 1

print("The number of RSA numbers between", start, "and", end, "is", sum)




# def isrsa(n):
#     c=0
#     for i in range(1, int(n**(1/2))+1):
#         if n%i==0:
#             c+=2
#             if c>4:
#                 return False
#     return c==4
    
# lb, ub = int(input()), int(input())
# ans = sum(1 for elem in range(lb, ub+1) if isrsa(elem))
# print(f"The number of RSA numbers between {lb} and {ub} is {ans}")
