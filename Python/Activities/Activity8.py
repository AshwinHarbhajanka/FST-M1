numbers= list(input("Enter a list of comma separated values: ").split(","))
print(numbers)
if numbers[0]==numbers[len(numbers)-1]:
    print("First and last elements of the list are same")
else: print("First and last elements of the list are not same")
