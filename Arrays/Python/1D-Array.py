# Python Program - One Dimensional Array
dec='y';
print("1D array");

while dec==('y'or'Y') :
    nval = int(input("How many element you want to store in the array ? "));
    arr = [];
    for i in range(0, nval):
        arr.append(input(f"Enter element at {i}th position "));
    print("\nElements in Array are:");
    print("[ ",end='');
    for i in range(0, nval):
        print(arr[i], end=" ");
    print("]");
    dec=input("Enter y to repeat; x to exit ");
