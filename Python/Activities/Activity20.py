import pandas as pd
data = pd.read_excel("Employees.xlsx")
print(data)
print(data.shape)
print(data['Email'])
print(data.sort_values('FirstName'))