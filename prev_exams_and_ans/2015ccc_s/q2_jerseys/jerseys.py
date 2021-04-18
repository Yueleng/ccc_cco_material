  
# CCC 2015 Senior 2: Jerseys
#
# The problem is simple.
# 1. store the jersy sizes. (no tricks required)
# 2. read reach request: if its a small -> satisfied
#                        if sizes match -> satisfied
#                        if its a M request for a L -> satisfied
#                        Once a jersy has been given out, mark it as "T" (taken)
#
# With some tweaking of the file input and converting a string to an integer using
# int(s,10) I was able to get the time for the last data set under 4 seconds 
# with my old machine (XP Pentium 4 CPU, 3.2Ghz, 1G RAM).
#

file = open("s2.6.in", "r")
j = int(file.readline())
a = int(file.readline())

sizes = []

# sizes = [M S S L]
for i in range(j):
    sizes.append (file.readline().strip())

requestsSatisfied = 0
for line in file:
    # PARSE THE number and then -1 to fit the index
    number = int(line[2:],10) - 1
    line = line[0]
    if sizes[number] != 'T':
        if line == 'S' or \
               line == sizes[number] or \
               (line == 'M' and sizes[number] == 'L'):
            requestsSatisfied = requestsSatisfied + 1
            sizes[number] = 'T'

print requestsSatisfied