package cs544.sdi2;

import org.springframework.stereotype.Service;

/**
 * Created by Adonai on 6/6/2017.
 */
@Service
public class InventoryService implements IInventoryService {

    public int getNumberInStock(int productNumber){
        return productNumber - 200;
    }
}
