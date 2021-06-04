import pandas as pd
data = pd.read_csv("Example.csv")
print(data['Usernames'])
print(data.values[1])
print(data.sort_values('Usernames'))
print(data.sort_values('Passwords',ascending = False))