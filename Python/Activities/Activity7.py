numbers = list(input("Enter a list of comma separated values to add: ").split(", "))
print(numbers)
sum=0
for number in numbers:
    sum+=int(number)
print(sum)
