package myJpetStore.persistence;

import java.util.List;
import myJpetStore.domain.Category;
/**
 * Created by songtie on 2015/4/21.
 */
public interface CategoryDAO
{
    //Select All Categories
    List<Category> getCategoryList();

    //Select a Category By ID
    Category getCategory(String categoryId);
}
