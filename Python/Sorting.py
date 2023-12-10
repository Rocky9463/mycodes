def selectionSort(arr):
    for i in range(len(arr)-1):
        for j in range(i+1, len(arr)):
            if arr[i] > arr[j]:
                arr[i], arr[j] = arr[j], arr[i]
    print("After sorting : ", arr)

def bubbleSort(arr):
    i = len(arr)-1
    while i >= 1:
        j=0
        while j<i:
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
            j+=1
        i-=1
    print("After sorting : ", arr)

def insertionSort(arr):
    i=1
    while(i<len(arr)):
        x=arr[i]
        j=i-1
        while(j>=0):
            if arr[j]>x:
                arr[j+1] = arr[j]
            else:
                break
            j-=1
        arr[j+1] = x
        i+=1
    print("After sorting : ", arr)
    

arr = [2,9,9,7,9,2,4,5,8]
#arr = [20,15,6,18,2]
print("Before sorting : ", arr)
shellSort(arr)