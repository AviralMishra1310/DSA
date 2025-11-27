public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    public void addAtFirst(int data){
        //step1 = create new node
        Node newNode = new Node(data);
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        //step2 - newNode next = head
        newNode.next = head; //link

        //step3 - make head = newNode
        head = newNode;
    }

    public void addAtLast(int data){
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {  
        if(head == null){
            System.out.println("LL is empty");
            return;
        }
        Node temp = head;
        while(temp != null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void addInBetween(int idx, int data){
        if(idx == 0){
            addAtFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;

        while(i < idx - 1){
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;

    }

    public int removeFirst() {
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        // we have to reach till prev and prev: i = size-2
        Node prev = head;
        for(int i = 0; i<size - 2; i++){
            prev = prev.next;
        }

        int val = prev.next.data; //tail.data
        prev.next = null;         //tail ko null kr diya
        tail = prev;              //tail ko prev wale par phncha diya
        size--;                   //size kam kr diya
        return val;                
    } 

    public int itrSearch(int key){ //O(n)
        Node temp = head;
        int i = 0;

        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }

        //key not found 
        return -1;
    }
    
    public int helper(Node head, int key){ //O(n)
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key); //isme wo dekhe ga key mili ya nhi mili to idx + 1 krke return kr dega aur mili hi nhi last tak to -1
        if(idx == -1){
            return -1;
        }     
        return idx + 1;
    }

    public int recSearch(int key){
        return helper(head,key);
    }

    public void reverse(){
    Node prev = null;          // pehle koi node nahi hai
    Node curr = tail = head;   // curr ko head par rakha, tail ko bhi update kiya
    Node next;

    while(curr != null){
        next = curr.next;      // next node ko store kiya
        curr.next = prev;      // link ko ulta kar diya
        prev = curr;           // prev ko ek step aage badha diya
        curr = next;           // curr ko ek step aage badha diya
    }
    head = prev;               // last node (prev) ab new head ban gaya
    }


    public void deleteNthfromEnd(int n){
        //calculate size 
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }
        if(n == sz){
            head = head.next; //removeFirst
            return;
        }
        int i = 1;
        int iToFind = sz - n; //sz - n tak iss liye chalaya kynki sz-n+1 to delete hi krna hai to uske ek pehle tak hi to phnchna pdega 
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next; //to prev.next ko garbage collector utha lega
        return;
    }

    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        
        while(fast != null && fast.next != null){
            slow = slow.next; //+1
            fast = fast.next.next; //+2
        }
        return slow; //slow is my midnode
    }

    public boolean checkPalindrome(){
        if(head == null || head.next == null){
           return true;
        }
        //step1 - find mid
        Node midNode = findMid(head);

        //step2 - reverse 2nd half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev; //right half ka head
        Node left = head;

        //step3 - check left half
        while(right != null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static boolean isCycle(){  //Floyd's CFA 
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow){
                return true;
            }
        }
        return false;
    }

    public static void removeCycle(){
        //detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }
        //find meeting point
        slow = head;
        Node prev = null;
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle -> last.next = null
        prev.next = null;
    }

    private Node getMid(Node head){
          Node slow = head;
          Node fast = head.next;

          while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
          }
          return slow;
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1 != null && head2 != null){
            if(head1.data <= head2.data){
               temp.next = head1;
               head1 = head1.next;
               temp = temp.next;
            }else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }
        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head; 
        }
        //find mid
        Node mid = getMid(head);
        //left & right MS
        Node righthead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(righthead);

        //merge
        return merge(newLeft, newRight);
    }

    public void zigZag() {
        //find mid
        Node slow = head;
        Node fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next; 
        }

        Node left = head;
        Node right = prev;
        Node nextL,nextR;

        //alt merge- zig zag merge
        while(left != null && right != null){
            nextL = left.next;   // left ka agla node store karo
            left.next = right;   // left ka next = right bana do
            nextR = right.next;  // right ka agla node store karo
            right.next = nextL;  // right ka next = left ka agla
    
            left = nextL;        // left pointer aage badhao
            right = nextR;       // right pointer aage badhao
        }
    }


    public static void main(String args[]) {
        LinkedList ll = new LinkedList();       
        ll.addAtLast(1);
        ll.addAtLast(2);
        ll.addAtLast(3); 
        ll.addAtLast(4);
        ll.addAtLast(5);

        ll.print();    
        ll.zigZag();
        ll.print();
        // System.out.println(ll.checkPalindrome());

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // //1->2->3->1
        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());
    }
}
