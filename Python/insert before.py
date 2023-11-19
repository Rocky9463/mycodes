class node:
    def __init__(self, data):
        self.next  = None
        self.data = data

class linkedlist:
    def __init__(self):
        self.head = None
        self.startlist()

    def startlist(self):
        i=1
        while(i):
            print('''\n__MENU__
1.Insert (append)
2.Insert before
3.display
4.Stop\n''')
            choice = int(input("Enter choice : "))
            match (choice):
                case 1:
                    self.insert()
                case 2:
                    self.insertb4()
                case 3:
                    self.display()
                case 4:
                    print("stopping.....")
                    i=0
            if (choice<1 or choice >4):
                    print("!!!! Invalid input !!!!!!")


    def isempty(self):
        if self.head == None:
            return True
        else:
            return False


    def display(self):
        if self.isempty():
            print("!!!! Underflow !!!!")
            return
        ptr = self.head
        while ptr != None:
            print(" -> ",ptr.data, end ="")
            ptr = ptr.next
        print()
        return

    def insert(self):
        data = input("Enter element : ")
        new_node = node(data)        
        if self.head is None:
            self.head = new_node
            return
        cur_node = self.head
        while cur_node.next is not None:
            cur_node = cur_node.next
        cur_node.next = new_node

    def insertb4(self):
        target_data = input("Enter target data : ")
        data = input("Enter new data : ")
        new_node = node(data)
        if self.head is None:
            print("The list is empty.")
            return
        if self.head.data == target_data:
            new_node.next = self.head
            self.head = new_node
            return
        cur_node = self.head
        while cur_node.next is not None:
            if cur_node.next.data == target_data:
                new_node.next = cur_node.next
                cur_node.next = new_node
                return
            cur_node = cur_node.next
        print("The target data is not found in the list.")


obj = linkedlist()
        
            
