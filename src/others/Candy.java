package others;

import java.util.Collections;

/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 * 
 * @param args
 */
public class Candy {

	public int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0)
			return 0;
		int[] inc = new int[ratings.length];
		for (int i = 1; i < ratings.length; i++)
			inc[i] = ratings[i] > ratings[i - 1] ? inc[i - 1] + 1 : 0;
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				inc[i] = Math.max(inc[i], inc[i + 1] + 1);
			}
		}

		int sum = ratings.length;
		for (int i = 0; i < ratings.length; i++)
			sum += inc[i];
		return sum;

	}

	public static void main(String[] args) {
		Candy t = new Candy();
		int[] ratings = new int[] { 4, 2, 3, 4, 1 };
		int num = t.candy(ratings);
		System.out.println(num);
	}

}
