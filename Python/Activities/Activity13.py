def sum(numbers):
    total = 0
    for number in numbers:
        total = total + number
    return total

numbers = [4,8,9,77]
print("Sum is: ",sum(numbers))