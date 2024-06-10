import mysql.connector
conn = mysql.connector.connect(host = 'localhost', user = 'root', passwd = '', database = 'practice')
mycursor = conn.cursor()

############################################################################

MAIN = []
NAME = ['KARAN','DIVYAKAR','DIVYA','ARUN','SABINA','JOHN','ROBERT','RUBINA','VIKAS','MOHAN']
STIPEND = [400.00,450.00,300.00,350.00,500.00,400.00,250.00,450.00,500.00,300.00]
AVGMARK = [78.5,89.2,68.6,73.1,90.6,75.4,64.4,88.5,92.0,67.5]
GRADE = ['B','A','C','B','A','B','C','A','A','C']
CLASS = ['12B','11C','12C','12C','11A','12B','11A','12A','12A','12C']
STREAM = ['MEDICAL','COMMERCE','COMMERCE','COMMERCE','HUMANITIES','NONMEDINAL','MECIAL','HUMANITIES','NONMEDICAL','NONMEDICAL','COMMERCE']
STR = "INSERT INTO STUDENT VALUES"
for i in range(1,11):
    MAIN.append(i-1)
    MAIN.append(NAME[i-1])
    MAIN.append(STIPEND[i-1])
    MAIN.append(AVGMARK[i-1])
    MAIN.append(GRADE[i-1])
    MAIN.append(CLASS[i-1])
    MAIN.append(STREAM[i-1])
    TUP = tuple(MAIN)
    TUP = str(TUP)
    STR += TUP
    print(STR)
    mycursor.execute(STR)
    conn.commit()

    
    STR = "INSERT INTO STUDENT VALUES"
    MAIN = []



############################################################################






