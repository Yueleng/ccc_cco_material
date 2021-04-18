money_left = int(input())
coins = [int(x) for x in input().split()]

def count(coins, len, money_left):
    if money_left == 0:
        return 1
    
    if money_left < 0: 
        return 0

    if len <= 0 and money_left > 0: 
        return 0

    return count(coins[1:], len - 1, money_left) + count(coins, len, money_left - coins[0])


print(count(coins, len(coins), money_left))