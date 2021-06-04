fruits = {
    "apple": 10,
    "banana": 4,
    "cherry": 5,
    "orange": 15
}
check = input("What fruit you need: ").lower()
if check in fruits:
    print("Available for "+str(fruits[check]))
else: print("Unavailable")