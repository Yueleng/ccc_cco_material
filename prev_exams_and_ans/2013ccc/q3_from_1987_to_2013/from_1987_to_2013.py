def is_distinct(year):
    nums = set()
    for s in str(year):
        if s in nums:
            return False
        nums.add(s)
    return True

year = int(input())
next_year = year + 1
while not is_distinct(next_year):
    next_year += 1

print(next_year)