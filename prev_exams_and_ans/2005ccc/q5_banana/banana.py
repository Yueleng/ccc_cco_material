
# if (words.length() > 0) {
#     int indxN = words.indexOf("N");
#     if (indxN >= 0) {
#         // check if N is optional letter followed by monkey language
#         boolean result = false;
#         for (int i = 0; i < words.length(); i++) {
#             if (words.charAt(i) == 'N') {
#                 result = result || (isA_Word(words.substring(0, i)) && isMonkeyLang(words.substring(i + 1)));
#                 if (result)
#                     break;
#             }
#         }
#         // check N is part of A-Word
#         if (!result)
#             return isA_Word(words);
#         return result;
#     } else
#         return isA_Word(words);
# }
# return false;



def is_monkey_lang(word):
    if len(word) > 0:
        indx_N = word.find("N")

        if (indx_N >= 0):
            # exist "N"
            # check if N is optional letter followed by monkey language
            result = False
            for i in range(len(word)):
                if (word[i] == "N"):
                    result = result or (is_a_word(word[:i]) and is_monkey_lang(word[i+1:]))
                if result:
                    break

            # check N is part of A-word
            if not result:
                return is_a_word(word)


            return result
        else:
            # does not exists "N"
            return is_a_word(word)

    return False;


def is_a_word(word):
    if len(word) > 0:
        indx_s = word.rfind("S")
        if word == "A":
            return True
        if word[0] == "B" and word[-1] == "S":
            return is_monkey_lang(word[1:len(word)-1])


while True:
    str = input()
    
    if str == "X":
        break

    print("YES" if is_monkey_lang(str) else "NO")
