templates
// time : O(?)
// space: O(?)

System.out.println();

2 inner forEach

```java
    for(int i=0;i<array.length;i++){
        for(int j=0;j<array[i].length;j++){
        
        }
        }
```

turtle & rabbit

```java
    ListNode slow=head,fast=head;
        while(fast!=null&&fast.next!=null){
        slow=slow.next;
        fast=fast.next.next;
        }
```

? Для чётных и не чётных элементов, где остановятся Указатели?
1 || s=1, f=1
1 - 2 || s=2, f=null
1 - 2 - 3 || s=2, f=3
1 - 2 - 3 - 4 || s=3, f=null
1 - 2 - 3 - 4 - 5 || s=3, f=5
1 - 2 - 3 - 4 - 5 - 6 || s=4, f=null

Reverse LinkedList || ListNode
```java
        ListNode prev = null, curr = ???, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
```
