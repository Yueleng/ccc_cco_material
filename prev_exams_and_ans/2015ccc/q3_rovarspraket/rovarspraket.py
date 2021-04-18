alphabet = "abcdefghijklmnopqrstuvwxyz"

word = input()

def is_vowel(c):
    return "aeiou".find(c) >= 0

def transform(c):
    return c + nearest_vowel(c) + next_consonant(c)


def nearest_vowel(c):
    index_of_c = alphabet.find(c)
    index_of_next_vowel = 100
    index_of_prev_vowel = -100
    for i in range(index_of_c-1, -1, -1):
        # starting from index_of_c - 1, decrease by 1, and large than -1(exclude -1)
        if (is_vowel(alphabet[i])):
            index_of_prev_vowel = i
            break

    for i in range(index_of_c+1, len(alphabet)):
        if (is_vowel(alphabet[i])):
            index_of_next_vowel = i
            break
    
    return (alphabet[index_of_prev_vowel] 
            if index_of_c - index_of_prev_vowel <= index_of_next_vowel - index_of_c 
            else alphabet[index_of_next_vowel])

def next_consonant(c):
    index_of_c = alphabet.find(c)
    for i in range(index_of_c+1, len(alphabet)):
        if (not is_vowel(alphabet[i])):
            return alphabet[i]
    return 'z'


output_string = ""
for i in range(0, len(word)):
    c = word[i]
    if (is_vowel(c)):
        output_string += c
    else: # c is not vowel, i.e. consonant
        output_string += transform(c)

print(output_string)