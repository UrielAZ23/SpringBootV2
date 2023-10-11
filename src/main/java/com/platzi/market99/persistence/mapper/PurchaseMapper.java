package com.platzi.market99.persistence.mapper;

import com.platzi.market99.domain.Purchase;
import com.platzi.market99.persistence.entity.Compra;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {


    @Mappings({
            @Mapping(source ="idCompra" ,target ="purchaseId" ),
            @Mapping(source ="idCliente" ,target ="clienteId" ),
            @Mapping(source ="fecha" ,target ="date" ),
            @Mapping(source ="medioPago" ,target ="paymentMethod" ),
            @Mapping(source ="comentario" ,target ="comment" ),
            @Mapping(source ="estado" ,target ="state" ),
            @Mapping(source ="productos" ,target ="items" ),
    })
    Purchase toPurchase(Compra compra);
    List<Purchase> toPurchase(List<Compra> compras);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "cliente",ignore = true)
    })
    Compra toCompra(Purchase purchase);
}
