from collections import defaultdict

line1_string = input()
line2_string = input()

line1 = defaultdict(int);
line2 = defaultdict(int);

for c in line1_string:
    line1[c] += 1

for c in line2_string:
    line2[c] += 1

flag = True
count = 0
for key in line1:
    if line1[key] < line2[key]:
        flag = False
        break
    if line1[key] > line2[key]:
        count += line1[key] - line2[key]

if count != line2['*']:
    flag = False

if (flag == False):
    print('N')
else:
    print('A')