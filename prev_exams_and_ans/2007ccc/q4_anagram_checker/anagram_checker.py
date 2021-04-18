import sys
from collections import defaultdict

input = sys.stdin.readline


a = input()
b = input()

d = defaultdict(lambda: 0) # d = defualtdict(0)

# print(len(a))
# print(len(b))

for word in a.split():
    for char in word:
        d[char] += 1

for word in b.split():
    for char in word:
        d[char] -= 1

print("Is an anagram." if all(x == 0 for x in d.values()) else 'Is not an anagram.')