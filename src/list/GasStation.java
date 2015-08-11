package list;

public class GasStation {

	/**
	 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique.
	 * @param args
	 */
    public static int canCompleteCircuit(int[] gas, int[] cost) {
    	int index=0;
    	int currentSum=0;
    	int total=0;
    	int len=gas.length;
    	for(int i=0;i<len;i++){
			currentSum+=gas[i]-cost[i];
			total+=gas[i]-cost[i];
			if(currentSum<0){
				index=i+1;
				currentSum=0;
			}
    	}
    	if(index<len-1) return index;
    	else if(index==len-1 && total>=0) return len-1;
    	else return -1;
    	
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] gas={2,4};
		int [] cost={3,4};
		System.out.println(canCompleteCircuit(gas, cost));

	}

}
