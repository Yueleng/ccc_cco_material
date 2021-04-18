num_of_lines = int(input())

def cold_compress(cum, rs):
    N = len(cum)
    # exit
    if (rs == ""):
        output_string = ""
        for s in cum:
            output_string += str(s) + " "
        return output_string

    # iteration
    if (N >= 2 and cum[N-1] == rs[0]):
        cnt = cum[N-2]
        cnt += 1
        cum[N-2] = cnt
        return cold_compress(cum, rs[1:])
    else:
        cum.append(1)
        cum.append(rs[0])
        return cold_compress(cum, rs[1:])

for i in range(0, num_of_lines):
    print(cold_compress([], input()))

