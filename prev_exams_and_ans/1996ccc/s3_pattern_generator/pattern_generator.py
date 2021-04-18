number = int(input())
for j in range(0, number):
    # n: num length
    # k: num of ones
    [n, k] = [int(i) for i in input().split()]
    s = ""
    for i in range(0, k):
        s = s + "1"
    for i in range(k, n):
        s = s + "0"
    
    print("The bit patterns are ")
    x = s.rfind("10")
    while (x >= 0):
        print(s)
        b = s[x+2:]
        s = s[:x] + "01" + b[::-1]
        x = s.rfind("10")
    print(s)
