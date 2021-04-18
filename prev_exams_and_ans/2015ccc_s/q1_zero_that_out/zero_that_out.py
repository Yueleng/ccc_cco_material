n = int(input())

stack = []
for i in range(0, n):
    num = int(input())
    if (num == 0):
        stack.pop()
    else:
        stack.append(num)

print(sum(stack))