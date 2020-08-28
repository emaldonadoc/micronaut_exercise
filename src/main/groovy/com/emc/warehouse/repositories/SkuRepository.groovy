package com.emc.warehouse.repositories

import com.emc.warehouse.entities.Sku
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface SkuRepository extends CrudRepository<Sku, Long> {
  Optional<Sku> findById(Long id)

  Sku save(Sku sku)
}
