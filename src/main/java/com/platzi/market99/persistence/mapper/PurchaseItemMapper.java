package com.platzi.market99.persistence.mapper;

import com.platzi.market99.domain.PurchaseItem;
import com.platzi.market99.persistence.entity.ComprasProducto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source ="id.idProducto" ,target ="productId" ),
            @Mapping(source ="cantidad" ,target ="quantity" ),
//            @Mapping(source ="total" ,target ="total" ),//Se puede suprimir por llamarse igual
            @Mapping(source ="estado" ,target ="avtive" )
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "compra",ignore = true),
            @Mapping(target = "producto",ignore = true),
            @Mapping(target = "id.idCompra",ignore = true),
    })
    ComprasProducto toComprasProducto(PurchaseItem item);

}
