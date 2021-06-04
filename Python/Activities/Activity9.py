odd = list((1,2,3,4,5,6,7,8))
print(odd)
even = list((4,1,3,5,7,32,6,11))
print(even)
final = list(())
for x in odd:
    if x%2!=0:
        final.append(x)
for x in even:
    if x%2==0:
        final.append(x)
print(final)
