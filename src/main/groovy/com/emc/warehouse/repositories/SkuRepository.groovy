package com.emc.warehouse.repositories

import com.emc.warehouse.entities.Sku

interface SkuRepository {
  Optional<Sku> findById(Long id)

  Sku save(Sku sku)
}
