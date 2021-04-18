stack = ["HOME"]

while True:
    instruction = input()
    if instruction == "SCHOOL":
        break
    elif instruction == "R":
        stack.append("LEFT")
    elif instruction == "L":
        stack.append("RIGHT")
    else:
        stack.append(instruction)


while len(stack) > 0:
    ins = stack.pop()
    loc = stack.pop()
    if (loc != "HOME"):
        print(f"Turn {ins} onto {loc} street.")
    else:
        print(f"Turn {ins} into your {loc}.")