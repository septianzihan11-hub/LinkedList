class Node:
    count = 0

    def __init__(self, nim, nama):
        self.nim = nim
        self.nama = nama
        self.next = None
        Node.count += 1


# Insert at beginning
def insert_at_front(head, nim, nama):
    new_node = Node(nim, nama)
    new_node.next = head
    return new_node


# Insert at given position
def insert_pos(head, pos, nim, nama):

    if pos < 1 or pos > Node.count + 1:
        return head

    if pos == 1:
        return insert_at_front(head, nim, nama)

    curr = head
    for _ in range(pos - 2):
        curr = curr.next

    new_node = Node(nim, nama)
    new_node.next = curr.next
    curr.next = new_node

    return head


# Insert at end
def insert_at_end(head, nim, nama):

    new_node = Node(nim, nama)

    if head is None:
        return new_node

    last = head
    while last.next is not None:
        last = last.next

    last.next = new_node
    return head


# Delete from beginning
def delete_head(head):

    if head is None:
        return None

    head = head.next
    Node.count -= 1
    return head


# Delete given position
def delete_pos(head, pos):

    if head is None or pos < 1 or pos > Node.count:
        return head

    if pos == 1:
        return delete_head(head)

    curr = head
    prev = None

    for _ in range(pos - 1):
        prev = curr
        curr = curr.next

    prev.next = curr.next
    Node.count -= 1
    return head


# Delete from end
def delete_end(head):

    if head is None:
        return None

    if head.next is None:
        Node.count -= 1
        return None

    curr = head
    while curr.next.next is not None:
        curr = curr.next

    curr.next = None
    Node.count -= 1
    return head


# Delete first occurrence by NIM
def delete_by_nim(head, nim):

    if head is None:
        return None

    if head.nim == nim:
        Node.count -= 1
        return head.next

    curr = head
    while curr.next is not None and curr.next.nim != nim:
        curr = curr.next

    if curr.next is not None:
        curr.next = curr.next.next
        Node.count -= 1

    return head


# Show data
def show_data(head):

    if head is None:
        print("Data kosong")
        return

    curr = head
    while curr is not None:
        print("NIM :", curr.nim, "| Nama :", curr.nama)
        curr = curr.next


# MAIN PROGRAM
head = None

while True:

    print("\n===== MENU LINKED LIST =====")
    print("1. Insert at beginning")
    print("2. Insert at given position")
    print("3. Insert at end")
    print("4. Delete from beginning")
    print("5. Delete given position")
    print("6. Delete from end")
    print("7. Delete first occurence (by NIM)")
    print("8. Show data")
    print("9. Exit")

    pilihan = int(input("Pilih: "))

    if pilihan == 1:
        nim = input("Masukkan NIM: ")
        nama = input("Masukkan Nama: ")
        head = insert_at_front(head, nim, nama)

    elif pilihan == 2:
        pos = int(input("Masukkan posisi: "))
        nim = input("Masukkan NIM: ")
        nama = input("Masukkan Nama: ")
        head = insert_pos(head, pos, nim, nama)

    elif pilihan == 3:
        nim = input("Masukkan NIM: ")
        nama = input("Masukkan Nama: ")
        head = insert_at_end(head, nim, nama)

    elif pilihan == 4:
        head = delete_head(head)

    elif pilihan == 5:
        pos = int(input("Masukkan posisi delete: "))
        head = delete_pos(head, pos)

    elif pilihan == 6:
        head = delete_end(head)

    elif pilihan == 7:
        nim = input("Masukkan NIM yang dihapus: ")
        head = delete_by_nim(head, nim)

    elif pilihan == 8:
        show_data(head)
        print("Jumlah data =", Node.count)

    elif pilihan == 9:
        print("Program selesai")
        break

    else:
        print("Pilihan tidak valid")
