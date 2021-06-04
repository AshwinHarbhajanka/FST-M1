def fibonacci(num):
    series = [1,1]
    if num>=2:
        i=2
        for i in range(2,num):
            series.append(series[i-1]+series[i-2])
            i+=1
        print(series)
    elif num==1:
        print(series[0])
    else: print("Invalid input")

num = int(input("Enter the length of sequence: "))
fibonacci(num)