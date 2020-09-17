package com.emc.warehouse.repositories

import com.emc.warehouse.entities.Sku
import com.emc.warehouse.enums.SkuType
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

@Repository
interface SkuRepository extends CrudRepository<Sku, Long> {
  Optional<Sku> findById(Long id)

  Optional<Sku> findByDescriptionAndType(String description, SkuType type)

  Sku save(Sku sku)
}
