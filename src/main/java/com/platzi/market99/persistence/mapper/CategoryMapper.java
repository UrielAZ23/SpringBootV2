package com.platzi.market99.persistence.mapper;

import com.platzi.market99.domain.Category;
import com.platzi.market99.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mappings(source="idCategoria",target="categoryId"),
            @Mappings(source="descripcion",target="category"),
            @Mappings(source="estado",target="active")
    })
    Category toCategory(Categoria categoria);

    @InheritInverseConfiguration
    @Mapping(target="productos",ingore=true)
    Categoria toCategoria(Category category);
}
