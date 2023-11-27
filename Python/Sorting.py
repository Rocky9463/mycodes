def selectionSort(arr):
    for i in range(len(arr)-1):
        for j in range(i+1, len(arr)):
            if arr[i] > arr[j]:
                arr[i], arr[j] = arr[j], arr[i]
    print("After sorting : ", arr)

arr = [2,9,9,7,9,2,4,5,8]
print("Before sorting : ", arr)
selectionSort(arr)