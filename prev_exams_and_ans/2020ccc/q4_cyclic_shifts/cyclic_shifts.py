#import sys
#input = sys.stdin.readline

t = input()
s = input()

def gen_cyclic(word):
    s_len = len(word)

    s_cyclic = []
    
    for i in range(0, s_len):
        s_cyclic.append(word[i:] + word[:i])

    return s_cyclic


flag = False
for cyclic in gen_cyclic(s):
    if cyclic in t: # if t.find(cyclic) >= 0:
        print("yes")
        flag = True
        break

if (flag == False):
    print("no")

