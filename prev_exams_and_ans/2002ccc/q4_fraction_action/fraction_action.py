numerator = int(input())
denominator = int(input())

quotient = int(numerator / denominator)
numerator -= quotient * denominator

if quotient != 0:
    print(quotient, " ", end='')

a = denominator
b = numerator

if (numerator != 0):
    while True:
        remainder = a % b
        a = b
        b = remainder

        if (remainder == 0):
            break
    gcd = a
    numerator /= gcd
    denominator /= gcd
        
    print(str(int(numerator)) + "/" + str(int(denominator)))

