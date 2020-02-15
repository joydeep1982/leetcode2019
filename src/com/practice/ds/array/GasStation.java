/**
 * 
 * https://leetcode.com/problems/gas-station/
 * 
 */
package com.practice.ds.array;

public class GasStation {
	
	public static void main(String[] args) {
		GasStation gs = new GasStation();
		int index = gs.canCompleteCircuit(new int[] {5,1,2,3,4}, new int[] {4,4,1,5,1});
		System.out.println(index);
	}
	
	public int canCompleteCircuit(int[] gas, int[] cost) {
        int circuit = gas.length;
        int startIndex = -1;

        for (int i = 0; i < circuit; i++) {
            if (cost[i] > gas[i]) {
                continue;   
            }
            else {
                startIndex = i;
                int pos = i;
                int gasInTank = 0;
                do {
                    gasInTank = gasInTank + gas[pos];
                    gasInTank = gasInTank - cost[pos];
                    
                    if (gasInTank < 0) {
                        startIndex = -1;
                        break;
                    }
                    
                    pos++;
                    if (pos >= circuit) {
                        pos = 0;
                    }
                    
                } while (pos != startIndex);
                
                if (startIndex != -1) {
                    break;
                }
            }
        }
        
        return startIndex;
    }

}
