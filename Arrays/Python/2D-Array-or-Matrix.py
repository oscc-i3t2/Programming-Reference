#Creation of 2D Array or Matrix
List=[]
print("Creation of 2D array or Matrix")
row=int(input("Enter the number of rows"))
col=int(input("Enter the number of columns"))
for i in range(row):
    r=[]
    for j in range(col):
        element=input("Enter ("+str(i)+","+str(j)+")th element")
        r.append(element)
    List.append(r)
print("2D array or Matrix created; the Matrix is:")
print("[")
for i in range(row):
    
    print(' [',end=' ')
    for j in range(col):
        print(List[i][j],end=' ')
    print(']')
print("]")
