package lxc.java;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Generics<E> {
	public E[] nums;
	
	//it's ok here.
	@SuppressWarnings("unchecked")
//	public E[]  get(E[] eles){
//		nums = (E[]) Array.newInstance(eles.getClass().getComponentType(), 3);
//		return nums;
//	}
	
	public E[] get(E[] eles){
		nums = (E[]) new Object[10];
		nums[0] = eles[0];
		return nums;
	}
	
	public static <T> List<T> create(Class<T> c){
		return new ArrayList<T>();
	}
	
	public static <T> T[] createArray_0(Class<T> c, int size){
		return (T[]) new Object[size];
	}
	public static <T> T[] createArray(Class<T> c, int size){
		return (T[]) Array.newInstance(c, size);
	}
	
	public static void print(Collection<?> eles, String... info){
		if (info.length > 0)
			System.out.println(info[0]);
		for (Object e : eles)
			System.out.println(e.toString());
	}
	
	public static void printNumber(Collection<? extends Number> eles, String... info){
		if (info.length > 0)
			System.out.println(info[0]);
		for (Number e : eles)
			System.out.println(e.toString());  // but still can't write.
	}
	

	
	public static <T> void addAll(T[] str, Collection<T> eles){
		for (T s : str)
			eles.add(s);
	}
	public static <T> void copyTo_0(Collection<T> src, Collection<T> dest){
		for (T ele : src){
			dest.add(ele);
		}
	}
	
	public static <T, S extends T> void copyTo(Collection<S> src, Collection<T> dest){
		for (S ele : src){
			dest.add(ele);
		}
	}
	
	public static <T> void copyTo2(Collection<? extends T> src, Collection<T> dest){
		for (T ele : src){
			dest.add(ele);
		}
	}
	
	public static <T> void copyTo3(Collection<T> src, Collection<? super T> dest){
		for (T ele : src){
			dest.add(ele);
		}
	}
	public static void main(String[] args) {
		//1. List<Object> is not the supertype of List<String>: compile error!
		List<String> as = new ArrayList<String>();
		//List<Object> ao = as;  wrong!
		
		//2. Object[] is supertype fo String[],but be careful about the assignment.
		String[] ss = new String[2];
		Integer[] ii = new Integer[2];
		Object[] oo = ss; 
		oo[0] = "right";
//		oo[1] = 1;  // no compile error, but runtime error!
		
		//3. wildcard ? indicates any unknown type:
		Collection<String> cs = new ArrayList<String>(); // fine
		cs.add("hello");
		print(cs);
		Collection<?> cs1 = new ArrayList<String>(); // wrong
//		cs1.add("hello");                            // can't add a specific type while cs1 contains unkown type.
		print(cs1);
		
		//4. bounded wildcard : extends, supers
//		printNumber(cs);  // not allowed!
		Collection<Integer> cs2 = new ArrayList<Integer>(); 
		cs2.add(1);
		printNumber(cs2);  // allowed! 
		
		//5. use generic method and type parameters to update!
		Integer[] nums = {1,2,3};
		Collection<Integer> cs3 = new ArrayList<Integer>();
		addAll(nums, cs3);
		print(cs3);
		printNumber(cs3);
		
		//6. typeparameters and bounded wildcards!
		Collection<Integer> src = new ArrayList<Integer>();
		src.add(1);
		src.add(2);
		Collection<Number> dest = new ArrayList<Number>();
//		copyTo_0(src,dest);                                // wrong. refer to 1.
		copyTo(src,dest);                                  // use type
		print(dest,"copy to : use type and bound extends");
		copyTo2(src,dest);                                 // use wildcard.
		print(dest,"copy to : use ? and bound extends");
		copyTo3(src,dest);                                 // use wildcard.
		print(dest,"copy to : use ? and bound super");     
		
		//8. create generic array.
//		Integer[] array_0 =  createArray_0(Integer.class,5);  // wrong.
		Integer[] array = createArray(Integer.class, 5);
		array[0] = 1;
		List<Integer> nu = create(Integer.class);
		System.out.println(""+nu);
		
		//use object. then cast correctly.
		Generics<String> gn = new Generics<String>();
		String[] eles = {"1","2"};
		Object [] ar = gn.get(eles);
		Integer t = (Integer) ar[0];
//		String t = (String) ar[0];
		System.out.println(t);
		
		//9. erase type parameter in runtime.
		List <String> l1 = new ArrayList<String>();
		List<Integer> l2 = new ArrayList<Integer>();
		System.out.println(l1.getClass() == l2.getClass());
		System.out.println(l1 instanceof Collection);    //true
//		System.out.println(l1 instanceof List<String>); // compile error
		//summary:
		//(1)  some Type S is used only once, use ?; else use type parameter.
		//(2) if want to bound type or wildcard, use extends or super.
		

		
	}

}
