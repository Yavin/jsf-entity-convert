package com.example.repository;

import com.example.entity.Category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
@RequestScoped
public class CategoryRepository extends Repository<Category> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public CategoryRepository() {
        setEntityClass(Category.class);
    }
}
