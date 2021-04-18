def longest_subpalindrome_slice(text):
    n = len(text)
    if n == 0: return ""

    str_table = [[False for x in range(n)] for y in range(n)]
    for i in range(n):
        str_table[i][i] = True # diagonal true
    
    start= 0
    end= 1

    # All substrings of length 1 are palindrome
    max_length = 1

    # Check for length greater than 1.
    # k is length of substring
    # k starts from 2
    k = 2

    while k <= n:
        # Fix the starting index
        i = 0
        while (i + k <= n):
            # Get the end index of substring
            # from starting index i and total length of k
            j = i + k - 1

            if (i == j - 1 or str_table[i+1][j-1]) and (text[i] == text[j]):
                str_table[i][j] = True
                if (k > max_length):
                    max_length = k
                    start = i
                    end = i + k

            i += 1

        k += 1
    return text[start:end]

print(longest_subpalindrome_slice("racecar"))
print(longest_subpalindrome_slice("racecarX"))
print(longest_subpalindrome_slice("race carr"))
print(longest_subpalindrome_slice("something rac e car going"))
print(longest_subpalindrome_slice("mad am i ma dam"))
print(longest_subpalindrome_slice("abcdefg"))



