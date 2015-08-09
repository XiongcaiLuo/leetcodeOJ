package oj;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

 class RandomListNode {
	      int label;
	      RandomListNode next;
	      RandomListNode(int x) { this.label = x; }
	  }
public class CopyListwithRandomPointer implements Serializable {


    public RandomListNode copyRandomList(RandomListNode head) {

        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oo=null;
        ByteArrayInputStream bi=null;
        ObjectInputStream oi=null;
		try {
			oo = new ObjectOutputStream(bo);
			 oo.writeObject(head);
		      bi = new ByteArrayInputStream(bo.toByteArray());
		     oi = new ObjectInputStream(bi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RandomListNode k=null;
		try {
			k = (RandomListNode) (oi.readObject());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException e){
			
		}
        return k;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
