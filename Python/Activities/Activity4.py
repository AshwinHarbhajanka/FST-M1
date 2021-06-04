user1 = input("Enter first username: ")
user2 = input("Enter second username: ")
i='yes'
while(i=='yes'):
    user1input = input(user1+" choose rock/paper/scissors: ").lower()
    user2input = input(user2+" choose rock/paper/scissors: ").lower()
    if ((user1input not in {'rock','paper','scissors'}) or (user2input not in {'rock','paper','scissors'})):
        print("Invalid input")
    elif user1input==user2input:
        print("It's a tie!")
    elif user1input == 'rock':
        if user2input == 'paper':
            print(user2+" wins!")
        else: print(user1+ " wins!")
    elif user1input == 'paper' :
        if user2input == 'rock':
            print(user1+" wins!")
        else: print(user2+" wins!")
    elif user1input == 'scissors' :
        if user2input == 'rock':
            print(user2+" wins!")
        else: print(user1+" wins!")
    j=input("do you want to play another round, choose yes/no: ")
    i=j