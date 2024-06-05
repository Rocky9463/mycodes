class node:
    def __init__(self, data):
        self.next  = None
        self.data = data

class linkedlist:
    def __init__(self):
        self.start = None
        self.startlist()

    def startlist(self):
        i=1
        while(i):
            print('''\n__MENU__
1.Insert (append)
2.Insert before
3.Insert after
4.Delete
5.Delete before
6.Delete after
7.display
8.Stop\n''')
            choice = int(input("Enter choice : "))
            match (choice):
                case 1:
                    self.insert()
                case 2:
                    self.insertb4()
                case 3:
                    self.insertafter()
                case 4:
                    self.delete()
                case 5:
                    self.deleteb4()
                case 6:
                    self.deleteafter()
                case 7:
                    self.display()
                case 8:
                    print("stopping.....")
                    i=0
            if (choice<1 or choice >8):
                    print("!!!! Invalid input !!!!!!")

    def isempty(self):
        if self.start == None:
            return True
        else:
            return False

    def display(self):
        if self.isempty():
            print("!!!! Underflow !!!!")
            return
        ptr = self.start
        while ptr != None:
            print(" -> ",ptr.data, end ="")
            ptr = ptr.next
        print()
        return

    def insert(self):
        data = input("Enter element : ")
        new_node = node(data)  
        print("___ Element inserted ___")      
        if self.start is None:
            self.start = new_node
            self.last = self.start
            return
        ptr = self.last
        ptr.next = new_node
        self.last = new_node

    def insertb4(self):
        target_data = input("Enter target data : ")
        data = input("Enter new data : ")
        new_node = node(data)
        if self.start is None:
            print("The list is empty.")
            return
        if self.start.data == target_data:
            new_node.next = self.start
            self.start = new_node
            return
        ptr = self.start
        while ptr.next is not None:
            if ptr.next.data == target_data:
                new_node.next = ptr.next
                ptr.next = new_node
                print("___ Element inserted ___")
                return
            ptr = ptr.next
        print("The target data is not found in the list.")

    def insertafter(self):
        target_data = input("Enter target data : ")
        data = input("Enter new data : ")
        new_node = node(data)
        if self.start is None:
            print("The list is empty.")
            return
        ptr = self.start
        while ptr is not None:
            if ptr.data == target_data:
                new_node.next = ptr.next
                ptr.next = new_node
                print("___ Element inserted ___")
                if new_node.next is None:
                    self.last = new_node
                return
            ptr = ptr.next
        print("The target data is not found in the list.")

    def delete(self):
        if self.isempty():
            print("!!!! Underflow !!!!")
            return
        target_data = input("Enter target data : ")
        self.ptr = self.start
        prev_node = None
        while self.ptr is not None:
            if self.ptr.data == target_data:
                if self.ptr == self.start:
                    self.start = self.ptr.next
                else:
                    if self.ptr.next == None:
                        self.last = prev_node
                    prev_node.next = self.ptr.next
                print("!!! Element deleted !!!")
                return
            else:
                prev_node = self.ptr
                self.ptr = self.ptr.next
        print("!!! Element not found !!!")

    def deleteb4(self):
        if self.isempty():
            print("!!!! Underflow !!!!")
            return
        target_data = input("Enter target data : ")
        self.ptr = self.start
        pre_prev = None
        prev = None
        c=0
        while self.ptr is not None:
            if self.ptr.data == target_data:
                c+=1
                break
            else:
                pre_prev = prev
                prev = self.ptr
                self.ptr = self.ptr.next
        if c==0:
            print("!!! Element not found !!!")
            return
        else:
            if self.ptr == self.start:
                print("!!! Deletion non possible !!!")
                return
            elif self.start.next == self.ptr:
                self.start = self.ptr
            else:
                pre_prev.next = self.ptr
        print("___ Element deleted ___")
    
    def deleteafter(self):
        if self.isempty():
            print("!!!! Underflow !!!!")
            return
        target_data = input("Enter target data : ")
        self.ptr = self.start
        pre_prev = None
        prev = None
        c=0      
        while self.ptr is not None:
            if self.ptr.data == target_data:
                c+=1
                break
            else:
                pre_prev = prev
                prev = self.ptr
                self.ptr = self.ptr.next
        if c==0:
            print("!!! Element not found !!!")
            return
        else:
            if self.ptr.next is None:
                print("!!! Deletion non possible !!!")
                return
            else:
                if self.ptr.next.next is None:
                    self.last = self.ptr
                p = self.ptr.next
                self.ptr.next = p.next
        print("___ Element deleted ___")
                 

obj = linkedlist()  
            
