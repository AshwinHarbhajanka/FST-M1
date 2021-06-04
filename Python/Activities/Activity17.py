import pandas as pd
data = dict(Usernames=['admin','Charles','Deku'],Passwords=['password','Charl13','AllMight'])
dataframe = pd.DataFrame(data)
dataframe.to_csv("Example.csv", index=False)