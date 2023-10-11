package com.platzi.market99.persistence;

import com.platzi.market99.domain.Purchase;
import com.platzi.market99.domain.repository.PurchaseRepository;
import com.platzi.market99.persistence.crud.CompraCrudRepository;
import com.platzi.market99.persistence.entity.Compra;
import com.platzi.market99.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;
    @Override
    public List<Purchase> getAll() {
        List<Compra> compras =(List<Compra>)    compraCrudRepository.findAll();
        return mapper.toPurchase(compras);
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchase(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra= mapper.toCompra(purchase);
        compra.getProductos().forEach( producto -> producto.setCompra(compra));

        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
