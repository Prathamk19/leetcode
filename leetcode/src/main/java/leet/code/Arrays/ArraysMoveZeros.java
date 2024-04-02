package leet.code.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysMoveZeros
{
    /*
     *  Input: nums = [0,1,0,3,12]
        Output: [1,3,12,0,0]
     * */
    public void moveZeroes(int[] nums) {
//        for (int i = 0, j = 0, zIndex = nums.length, cnt = 0; i < nums.length - cnt ; i++)
//        {
//            if (nums[i] == 0)
//            {
//                j = i - 1;
//                zIndex--;
//                cnt++;
//                while (j < zIndex - cnt)
//                {
//                    nums[++j] = nums[j+1];
//                }
//                nums[zIndex] = 0;
//            }
//        }
        
        int j = 0;
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                j = i + 1;
                while (j < nums.length - 1 && nums[j] == 0)
                {
                    j++;
                }
                if (j < nums.length)
                {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }
    
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }
    
    static boolean hasCycle(SinglyLinkedListNode head) {

        if (head == null || head.next == null)
            return false;
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head.next;
        while (slow != null && fast != null && slow != fast)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast)
        {
            return true;
        }
        return false;
    }
    
    /*
     *  17
        978
        409
        229
        934
        299
        982
        636
        14
        866
        815
        64
        537
        426
        670
        116
        95
        630
        
        
        17
        502
        518
        196
        106
        405
        452
        299
        189
        124
        506
        883
        753
        567
        717
        338
        439
        145
     * */
    public static void main(String[] args)
    {
       ArraysMoveZeros a = new ArraysMoveZeros();
       a.moveZeroes(new int[] {0,1,0,3,0,12,0,8,8,8,8});
       a.moveZeroes(new int[] {0,0,0,1,0});
       a.moveZeroes(new int[] {0,0,0,0,0,0});
       a.moveZeroes(new int[] {0,0,0,1,0,1});
       a.moveZeroes(new int[] {1,3,12,8,8,8,8});
        
        List<Integer> num = new ArrayList<>();
        num.add(1);
        num.add(2);
        num.add(3);
        num.add(4);
        num.add(5);
        int no = 4;
        int[] arrNum = new int[num.size()];
        for(int n = 0; n< num.size(); n ++)
        {
            arrNum[n] = num.get(n);
        }
        for (int i = 0; i<no; i++)
        {
            int forLast = arrNum[0];
            int j;
            for (j = 1; j < arrNum.length; j++)
            {
                arrNum[j - 1] = arrNum[j];
            }
            arrNum[j - 1] = forLast;
        }
        
        List<Integer> arrival = new ArrayList<>();
        arrival.add(1);
        arrival.add(2);
        arrival.add(5);
        Collections.sort(arrival);
        List<Integer> duration =  new ArrayList<>();
        duration.add(2);
        duration.add(2);
        duration.add(2);
        int result= 0;
        
        for (int i = 0; i<arrival.size(); i++)
        {
            if (i < arrival.size() - 1 && (arrival.get(i) + duration.get(i)) <= arrival.get(i + 1))
            {
                result++;
            }
            else if (i > 1 && arrival.get(i) >= (arrival.get(i-1) + duration.get(i-1)))
            {
                result++;
            }
        }
        System.out.println(result);
               
        
        
        int temp= 6;
        int cnt = 0;
        while (temp > 4)
        {
            temp-=4;
            cnt++;
        }
        System.out.println(cnt + temp/2);
        
        SinglyLinkedListNode n1 = new SinglyLinkedListNode(2);
        SinglyLinkedListNode n2 = new SinglyLinkedListNode(3);
        SinglyLinkedListNode n3 = new SinglyLinkedListNode(4);
        SinglyLinkedListNode n4 = new SinglyLinkedListNode(6);
        SinglyLinkedListNode n5 = new SinglyLinkedListNode(7);
        SinglyLinkedListNode n6 = new SinglyLinkedListNode(9);
        hasCycle(n1);
    }
}
