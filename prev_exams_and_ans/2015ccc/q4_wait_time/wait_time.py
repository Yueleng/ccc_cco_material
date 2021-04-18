# <friendId, [waitTime, indicator(-1 or timeStamp)]}>
# #  indicator: -1 if all cleared up; timeStamp if not cleared up;

wait_time_table = {}

rows = int(input())
time_stamp = 0
for i in range(0, rows):
    rowInfo = input().split()
    action = rowInfo[0]

    if (action != "W"):
        # action equals R or S
        friendId = rowInfo[1]
        if friendId not in wait_time_table:
            friendInfo = [0, time_stamp]
            wait_time_table[friendId] = friendInfo
        else: # old friend
            # old friend, either "S" to complete conversation
            #                  or "R" to start a new conversation
            friendInfo = wait_time_table[friendId]
            if (action == "S"):
                friendInfo[0] = friendInfo[0] + (time_stamp - friendInfo[1])
                friendInfo[1] = -1 # indicator: -1; complete conversation
                wait_time_table[friendId] = friendInfo
            else: # /"R"/ 
                friendInfo[1] = time_stamp
                wait_time_table[friendId] = friendInfo
        time_stamp += 1
    else: # action equals W
        time_stamp += int(rowInfo[1]) - 1

friend_array = list(wait_time_table.keys())
friend_array.sort()
for friend in friend_array:
    friendInfo = wait_time_table[friend]
    print(friend, friendInfo[0] if friendInfo[1] == -1 else -1)