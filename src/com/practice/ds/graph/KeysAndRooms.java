package com.practice.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
	
	public static void main(String[] args) {
		
		List<List<Integer>> rooms = new ArrayList<List<Integer>>();
		rooms.add(Arrays.asList(4));
		rooms.add(Arrays.asList(3));
		rooms.add(Arrays.asList());
		rooms.add(Arrays.asList(2,5,7));
		rooms.add(Arrays.asList(1));
		rooms.add(Arrays.asList());
		rooms.add(Arrays.asList(8,9));
		rooms.add(Arrays.asList());
		rooms.add(Arrays.asList());
		rooms.add(Arrays.asList(6));
		
		KeysAndRooms obj = new KeysAndRooms();
		boolean result = obj.canVisitAllRooms(rooms);
		System.out.println("result: " + result);
	}
	
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		int num_rooms = rooms.size();
        boolean[][] access_matrix = new boolean[num_rooms][num_rooms];
        
        for (int i = 0; i < num_rooms; i++) {
            List<Integer> room_keys = rooms.get(i);
            for (Integer index : room_keys) {
                access_matrix[i][index] = true;
            }
        }
        
        Set<Integer> visited = new HashSet<Integer>();
        visit(access_matrix, visited, 0);
        return visited.size() == rooms.size();
	}
	
	public void visit(boolean[][] access_matrix, Set<Integer> visited, int index) {
		visited.add(index);
		for(int i  = 0; i < access_matrix[index].length; i++) {
			if (access_matrix[index][i] && !visited.contains(i)) {
				visit(access_matrix, visited, i);
			}
		}
	}
}
