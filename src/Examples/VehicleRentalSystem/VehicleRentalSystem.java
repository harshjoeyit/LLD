package Examples.VehicleRentalSystem;

import java.util.ArrayList;
import java.util.List;

// for CRUD ops on users and store
public class VehicleRentalSystem {
    List<User> users;
    List<Store> stores;
   
    public VehicleRentalSystem(List<User> users, List<Store> stores) {
        this.users = users;
        this.stores = stores;
    }

    // search store based on location
    // the function actually searches based on pincode, could be changed to 
    // seach on city, state, etc
    public List<Store> searchStore(Location location) {
        List<Store> result = new ArrayList<Store>();

        for (Store store : this.stores) {
            // search based on pincode
            if (store.location.pincode == location.pincode) {
                result.add(store);
            }
        }

        return result;
    }
}
