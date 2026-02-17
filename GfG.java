import java.util.Scanner;

class Node {
    String nim;
    String nama;
    Node next;
    static int count = 0;

    Node(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
        this.next = null;
        count++; // insert otomatis tambah count
    }
}

public class GfG {

    // Insert at beginning
    static Node insertAtFront(Node head, String nim, String nama) {
        Node newNode = new Node(nim, nama);
        newNode.next = head;
        return newNode;
    }

    // Insert at given position
    static Node insertPos(Node head, int pos, String nim, String nama) {

        if (pos < 1 || pos > Node.count + 1)
            return head;

        if (pos == 1) {
            Node newNode = new Node(nim, nama);
            newNode.next = head;
            return newNode;
        }

        Node curr = head;

        for (int i = 1; i < pos - 1; i++)
            curr = curr.next;

        Node newNode = new Node(nim, nama);
        newNode.next = curr.next;
        curr.next = newNode;

        return head;
    }

    // Insert at end
    static Node insertAtEnd(Node head, String nim, String nama) {

        Node newNode = new Node(nim, nama);

        if (head == null)
            return newNode;

        Node last = head;

        while (last.next != null)
            last = last.next;

        last.next = newNode;
        return head;
    }

    // Delete from beginning
    static Node deleteHead(Node head) {

        if (head == null)
            return null;

        head = head.next;
        Node.count--;
        return head;
    }

    // Delete given position
    static Node deleteNode(Node head, int position) {

        if (head == null)
            return null;

        if (position < 1 || position > Node.count)
            return head;

        if (position == 1) {
            head = head.next;
            Node.count--;
            return head;
        }

        Node temp = head;
        Node prev = null;

        for (int i = 1; i < position; i++) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = temp.next;
        Node.count--;
        return head;
    }

    // Delete from end
    static Node removeLastNode(Node head) {

        if (head == null)
            return null;

        if (head.next == null) {
            Node.count--;
            return null;
        }

        Node secondLast = head;

        while (secondLast.next.next != null)
            secondLast = secondLast.next;

        secondLast.next = null;
        Node.count--;
        return head;
    }

    // Delete first occurrence by NIM
    static Node deleteByNim(Node head, String nim) {

        if (head == null)
            return null;

        if (head.nim.equals(nim)) {
            head = head.next;
            Node.count--;
            return head;
        }

        Node curr = head;

        while (curr.next != null && !curr.next.nim.equals(nim))
            curr = curr.next;

        if (curr.next != null) {
            curr.next = curr.next.next;
            Node.count--;
        }

        return head;
    }

    // Show data
    static void printList(Node head) {

        if (head == null) {
            System.out.println("Data kosong");
            return;
        }

        Node curr = head;

        while (curr != null) {
            System.out.println("NIM : " + curr.nim + " | Nama : " + curr.nama);
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Node head = null;
        int pilihan;

        do {
            System.out.println("\n===== MENU LINKED LIST =====");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at given position");
            System.out.println("3. Insert at end");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete given position");
            System.out.println("6. Delete from end");
            System.out.println("7. Delete first occurence (by NIM)");
            System.out.println("8. Show data");
            System.out.println("9. Exit");
            System.out.print("Pilih: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {

                case 1:
                    System.out.print("Masukkan NIM: ");
                    String nim1 = sc.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama1 = sc.nextLine();
                    head = insertAtFront(head, nim1, nama1);
                    break;

                case 2:
                    System.out.print("Masukkan posisi: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Masukkan NIM: ");
                    String nim2 = sc.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama2 = sc.nextLine();
                    head = insertPos(head, pos, nim2, nama2);
                    break;

                case 3:
                    System.out.print("Masukkan NIM: ");
                    String nim3 = sc.nextLine();
                    System.out.print("Masukkan Nama: ");
                    String nama3 = sc.nextLine();
                    head = insertAtEnd(head, nim3, nama3);
                    break;

                case 4:
                    head = deleteHead(head);
                    break;

                case 5:
                    System.out.print("Masukkan posisi delete: ");
                    int delPos = sc.nextInt();
                    head = deleteNode(head, delPos);
                    break;

                case 6:
                    head = removeLastNode(head);
                    break;

                case 7:
                    System.out.print("Masukkan NIM yang dihapus: ");
                    String delNim = sc.nextLine();
                    head = deleteByNim(head, delNim);
                    break;

                case 8:
                    printList(head);
                    System.out.println("Jumlah data = " + Node.count);
                    break;

                case 9:
                    System.out.println("Program selesai");
                    break;

                default:
                    System.out.println("Pilihan tidak ada");
            }

        } while (pilihan != 9);
    }
}
