from math import floor
def binsearch(a, i, l, x):
    if (l==i):
        if x == a[i]:
            return i
        else:
            return 0
    else:
        mid = floor((i+l)/2)
        if(x==a[mid]):
            return mid
        elif (x<a[mid]):
            return binsearch(a, i, mid-1, x)
        else:
            return binsearch(a, mid+1, l, x)

a = [1,2,3,4,5,6,7,8,9]
i=0
l=len(a)
x = 4
result = binsearch(a, i, l, x)
if result==0:
    print("Element not found")
else:
    print("element found at : ", result)
