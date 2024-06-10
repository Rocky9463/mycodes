print('When i was young')

string = input('Enter a string with multiple world : ')
i = 0
x = ''
while i < len(string):
    if string[i].isspace():
        print(x.capitalize(), end = ' ')
        i = i+1
        x = ''
    else:
        x = x+string[i]
        i+=1
        if i == len(string):
            print(x.capitalize(), end = ' ')
        