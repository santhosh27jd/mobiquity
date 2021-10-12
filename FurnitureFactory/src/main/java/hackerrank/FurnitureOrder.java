package hackerrank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
	HashMap<Furniture, Integer> furnitureDetails = null;
    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
	
    FurnitureOrder() {
        // TODO: Complete the constructor
    	furnitureDetails = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
    	if(furnitureDetails.containsKey(type)) {
    		int val = furnitureDetails.get(type);
    		int tot = val + furnitureCount;
    		furnitureDetails.put(type, tot);
    	}else {
        	furnitureDetails.put(type, furnitureCount);
    	}
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return furnitureDetails;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
    	float cost = 0;
    	if(!furnitureDetails.isEmpty()) {
    		Set<Entry<Furniture, Integer>> detail = furnitureDetails.entrySet();
    		Iterator<Entry<Furniture, Integer>> it = detail.iterator();
    		while(it.hasNext()) {
        		Entry<Furniture, Integer> val = it.next();
        		Furniture fur = val.getKey();
        		int tol = val.getValue();
        		float fcost = fur.cost();
        		float sum = fcost * tol;
        		cost = cost + sum;
        	}
    	}
        return cost;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
    	if(!furnitureDetails.isEmpty()) {
    		if(furnitureDetails.containsKey(type)) {
    			return furnitureDetails.get(type);
    		}
    	}
        return 0;
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
    	if(!furnitureDetails.isEmpty()) {
    		if(furnitureDetails.containsKey(type)) {
    			int tot = furnitureDetails.get(type);
    			float cost = tot * type.cost();
    			return cost;
    		}
    	}
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
    	int total = 0;
    	if(!furnitureDetails.isEmpty()) {
    		Set<Entry<Furniture, Integer>> detail = furnitureDetails.entrySet();
    		Iterator<Entry<Furniture, Integer>> it = detail.iterator();
    		while(it.hasNext()) {
        		Entry<Furniture, Integer> val = it.next();
        		total = total + val.getValue();
        	}
    	}
        return total;
    }
}