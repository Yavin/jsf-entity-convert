package com.example;

import com.example.entity.Category;
import com.example.repository.CategoryRepository;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoryConverter implements Converter {

    @Inject
    private CategoryRepository categoryRepository;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        return categoryRepository.find(Integer.parseInt(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o == null || !(o instanceof Category)) {
            return null;
        }

        return ((Category) o).getId().toString();
    }
}
