import matplotlib.pyplot as plt



##########  FUNCTIONS  ##########
def x_cord():                       #      <----------------------------------- function for x coordinate
    val = input('Enter all x coordinates (seperated by space) : ')
    value = val.split()
    i = 0
    x_values = []
    while i<len(value):
        x_values.append(int(value[i]))
        i += 1
    return(x_values)

def y_cord(): #                             <---------------------------------- function for y coordinate
    val = input('Enter all y coordinates (seperated by space) : ')
    value = val.split()
    i = 0
    y_values = []
    while i<len(value):
        y_values.append(int(value[i]))
        i += 1
    return(y_values)

def pie_values():
    val = input('Enter all values (seperated by space) : ')
    value = val.split()
    i = 0
    x_values = []
    while i<len(value):
        x_values.append(int(value[i]))
        i += 1
    return(x_values)
    

def bye():#                                     <------------------------------ function to close
    print('##########  BYE  ##########')




def line_chart():#                                      <---------------------- function for line chart
    try:
        x = x_cord()
        y = y_cord()
        if len(x) == len(y):
            plt.plot(x,y)
            plt.show()
            print('1. Retry')
            print('2. Main menu')
            print('3. Quit')
            choice = input('Enter your choice : ')
            if choice.isdigit() and choice == '1':
                line_chart()
            elif choice.isdigit() and choice == '3':
                bye()
            else:
                main_menu()
        else:
            print()
            print('##########  Enter equal number of coordinates of x and y  #############')
            line_chart()
    except:
        print('##########  INVALID INPUT  ##########')
        x = input('Do you want to retry? (y/n) : ')
        if x.lower() == 'y':
            line_chart()
        else:
            print('bye')
            main_menu()
            
            
def bar_chart():#                                       <---------------------- function for bar chart
    try:
        x = x_cord()
        y = y_cord()
        if len(x) == len(y):
            plt.bar(x,y)
            choice = input('Do you want to labels?(y/n) : ')
            if choice.lower() == 'y':
                label = input('Enter all labels on x axis (seperated by space) : ')
                label = label.split()
                plt.xticks(x,label)
                plt.show()
            else:
                plt.show()
            print('1. Retry')
            print('2. Main menu')
            print('3. Quit')
            choice = input('Enter your choice : ')
            if choice.isdigit() and choice == '1':
                bar_chart()
            elif choice == '3':
                bye()
            else:
                main_menu()
        else:
            print()
            print('##########  Enter equal number of coordinates of x and y  #############')
            bar_chart()
        
    except:
        print('##########  INVALID ENTRY  ##########')
        x = input('Do you want to retry? (y/n) : ')
        if x.lower() == 'y':
            bar_chart()
        else:
            print('bye')
            main_menu()
            
def pie_chart():#                                       <---------------------- function for pie chart
    try:
        x = pie_values()
        label = input('Enter all labels on x axis (seperated by space) : ')
        label = label.split()
        if len(x) == len(label):
            plt.pie(x,labels = label)
            plt.show()
            print('1. Retry')
            print('2. Main menu')
            print('3. Quit')
            choice = input('Enter your choice : ')
            if choice.isdigit() and choice == '1':
                pie_chart()
            elif choice == '3':
                bye()
            else:
                main_menu()
        else:
            print()
            print('##########  Enter equal number of coordinates of x and y  #############')
            pie_chart()
    except:
        print('##########  INVALID ENTRY  ##########')
        x = input('Do you want to retry? (y/n) : ')
        if x.lower() == 'y':
            pie_chart()
        else:
            print('bye')
            main_menu()
        
        
        
        
        






def main_menu():#                                       <---------------------- function for main menu
    print('Easy Graph')
    print('An easy way to make graphs')

    print('MENU')   
    print('''          1. Line chart
          2. Bar chart
          3. Pie chart
          4. Quit
          ''') 
    cd_main = True      
    while cd_main :
        choice = input("Enter your choice : ")

        if choice.isdigit() and int(choice)>0 and int(choice)<5:
            if choice == '1':
                line_chart()
                cd_main = False
            elif choice == '2':
                bar_chart()
                cd_main = False
            elif choice == '3':
                pie_chart()
                cd_main = False
            elif choice == '4':
                bye()
                cd_main = False

        else:
            print('##########  INVALID INPUT  #########')
            x = input('Do you want to retry? (y/n) :  ')
            if x.lower()=='y':
                cd_main = True
            else:
                bye()
                cd_main = False
                
                
main_menu()
                









































































































































