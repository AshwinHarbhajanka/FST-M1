numbers = tuple(input("Enter the numbers (comma separated values) : ").split(","))
print(numbers)
for x in numbers:
    if int(x)%5==0:
        print(x)
