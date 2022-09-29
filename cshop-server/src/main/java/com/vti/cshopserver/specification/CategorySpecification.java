package com.vti.cshopserver.specification;

import com.vti.cshopserver.entity.Category;
import com.vti.cshopserver.entity.Category_;
import com.vti.cshopserver.entity.Product;
import com.vti.cshopserver.entity.Product_;
import com.vti.cshopserver.form.CategoryFilterForm;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class CategorySpecification {
    public static Specification<Category> buildWhere(CategoryFilterForm form) {
        if (form == null) {
            return null;
        }
        return hasNameLike(form.getSearch())
                .or(hasProductNameLike(form.getSearch()));
    }

    private static Specification<Category> hasProductNameLike(String search) {
        return(root, query, builder) -> {
        if (!StringUtils.hasText(search)) {
            return null;
        }
            Join<Category, Product> join = root.join(Category_.products, JoinType.LEFT);
            return builder.like(join.get(Product_.name), "%" + search.trim() + "%");
        };
    }
    private static Specification<Category> hasNameLike(String search) {
        return(root, query, builder) -> {
        if(!StringUtils.hasText(search)) {
            return null;
        }

            return builder.like(root.get(Category_.name), "%" + search.trim() + "%");
        };
    }
}
