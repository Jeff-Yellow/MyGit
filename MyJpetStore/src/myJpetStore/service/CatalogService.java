package myJpetStore.service;


import myJpetStore.domain.Category;
import myJpetStore.domain.Product;
import myJpetStore.domain.Item;
import myJpetStore.persistence.CategoryDAO;
import myJpetStore.persistence.ItemDAO;
import myJpetStore.persistence.ProductDAO;
import myJpetStore.persistence.impl.CategoryDAOImpl;
import myJpetStore.persistence.impl.ItemDAOImpl;
import myJpetStore.persistence.impl.ProductDAOImpl;

import java.util.List;

/**
 * Created by songtie on 2015/4/21.
 */
public class CatalogService
{
    private CategoryDAO categoryDAO;
    private ProductDAO productDAO;
    private ItemDAO itemDAO;

    public CatalogService()
    {
        categoryDAO = new CategoryDAOImpl();
        productDAO = new ProductDAOImpl();
        itemDAO = new ItemDAOImpl();
    }


    public List<Category> getCategoryList() {
        return categoryDAO.getCategoryList();
    }

    public Category getCategory(String categoryId) {
        return categoryDAO.getCategory(categoryId);
    }

    public Product getProduct(String productId) {
        return productDAO.getProduct(productId);
    }

    public List<Product> getProductListByCategory(String categoryId) {
        return productDAO.getProductListByCategory(categoryId);
    }

    // TODO enable using more than one keyword
    public List<Product> searchProductList(String keyword) {
        return productDAO.searchProductList("%" + keyword.toLowerCase() + "%");
    }
    public List<String> getProductName(){
    	return productDAO.getProductName();
    }


    public List<Item> getItemListByProduct(String productId) {
        return itemDAO.getItemListByProduct(productId);
    }

    public Item getItem(String itemId) {
        return itemDAO.getItem(itemId);
    }

    public boolean isItemInStock(String itemId) {
        return itemDAO.getInventoryQuantity(itemId) > 0;
    }

}
