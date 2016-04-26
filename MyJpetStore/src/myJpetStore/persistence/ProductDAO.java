package myJpetStore.persistence;

import myJpetStore.domain.Product;
import java.util.List;

/**
 * Created by songtie on 2015/4/21.
 */
public interface ProductDAO {


    List<Product> getProductListByCategory(String categoryId);

    Product getProduct(String productId);

    List<Product> searchProductList(String keywords);
    List<String> getProductName();
}
