//package oj;
//
//import java.awt.List;
//import java.util.ArrayList;
//
//
//class ListNode{
//    int val;
//    ListNode next;
//    ListNode(int x) {
//        val = x;
//        next = null;
//    }
//}
//public class InsertionSortList {
//
//	/**
//	 * @param args
//	 */
//	public static void InsersionSort(int[]A){
//		if(A.length==0){
//			System.out.println("the array is empty!");
//			return;
//		}
//		else {
//			for(int j=1;j<A.length;j++){
//				int key=A[j];
//				int i=j-1;
//				while(i>=0&&A[i]>key){
//					A[i+1]=A[i];
//					i--;
//				}
//				A[i+1]=key;
//			}
//		}
//	}
//	public static ListNode insertionSortList(ListNode head){
//		ListNode ptr=head;
//		ArrayList<Integer> nums=new ArrayList();
//		while(ptr!=null){
//			nums.add(ptr.val);
//			ptr=ptr.next;
//		}
//		int[]A=new int[nums.size()];
//		for(int i=0;i<nums.size();i++)
//			A[i]=nums.get(i);
//			
//		InsersionSort(A);
//		ptr=head;
//		int i=0;
//		while(ptr!=null){
//			ptr.val=A[i];
//			i++;
//			ptr=ptr.next;
//		}
//		return head;
//	}
//	public static void print(ListNode head){
//		while(head!=null){
//			System.out.println(head.val);
//			head=head.next;
//		}
//	}
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ListNode head=new ListNode(3);
//		head.next=new ListNode(4);
//		head.next.next=new ListNode(1);
//		ListNode n=insertionSortList(head);
//		print(n);
//	}
//
//}
