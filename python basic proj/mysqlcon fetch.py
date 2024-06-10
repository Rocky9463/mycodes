import mysql.connector
a = 'practice'
conn = mysql.connector.connect(host = 'localhost', user = 'root', passwd = '', database = a)
mycursor = conn.cursor()
mycursor.execute('desc t')
data = mycursor.fetchall()
for i in data:
    print(i)