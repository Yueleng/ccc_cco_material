import sys
input = sys.stdin.readline

matrix = []

def checkMagic(matrix):
    compare = sum(matrix[0])
    # horizontal
    for i in range(0, len(matrix)):
        if (compare != sum(matrix[i])):
            # print("Here: ", matrix[i])
            return False

    # vertical
    transpose_matrix = list(zip(*matrix))
    for i in range(0, len(transpose_matrix)):
        if (compare != sum(transpose_matrix[i])):
            # print("Here: ", transpose_matrix[i])
            return False

    return True

for i in range(0, 4):
    row = [int(x) for x in input().split()]
    matrix.append(row)

if (checkMagic(matrix)):
    print("magic")
else:
    print("not magic")