start_time = [int(x) for x in input().split(":")]

def speed(time):
    if (time[0] >= 7 and time[0] <= 9) or (time[0] >= 15 and time[0] <= 18):
        return 0.5
    else:
        return 1

def arrived_time(start_time):
    distance = 0
    start_hour = start_time[0]
    start_min = start_time[1]
    while (distance < 120.0):
        new_time = [start_hour, start_min]
        distance = distance + speed(new_time)
        start_min += 1
        if (start_min == 60):
            start_min = 0
            start_hour += 1
            if (start_hour == 24):
                start_hour = 0

    return (("0" if start_hour <= 9 else "") + str(start_hour) + ":" 
           + ("0" if start_min <= 9 else "") + str(start_min))
                


print(arrived_time(start_time))

