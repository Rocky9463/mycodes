def linearSearch(arr, element):
    n = len(arr)
    i=0
    while i<n:
        if arr[i] == element:
            print("Element found at position : ", i+1)
            return
        else:
            i+=1
    print("Element not found")

arr = [2,9,9,7,9,2,4,5,8]
element = int(input("Enter element to search : "))
linearSearch(arr, element)