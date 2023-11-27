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

def binarySearch(arr, element):
    h = len(arr)-1
    l = 0
    while(l<=h):
        m = (l+h)//2 
        if arr[m] == element:
            print("Element found at position : ", m+1)
            return
        else:
            if element > arr[m]:
                l = m+1
            else:
                h = m-1
    print("Element not found")


arr = [2,9,9,7,9,2,4,5,8]
element = int(input("Enter element to search : "))
#linearSearch(arr, element)

arr.sort()
binarySearch(arr, element)