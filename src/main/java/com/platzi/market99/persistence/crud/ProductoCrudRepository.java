package com.platzi.market99.persistence.crud;

import com.platzi.market99.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {
//@Query(value = "SELECT * FROM productos WHERE=id_categoria = ?",nativeQuery = true)
//List<Producto> find(int idCategoria);

    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock,boolean estado);
}
