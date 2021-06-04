def sum(num):
    if num<=1:
        return num
    else:
        return num + sum(num-1)

num = int(input("Enter number: "))
print("The sum of numbers is ",sum(num))