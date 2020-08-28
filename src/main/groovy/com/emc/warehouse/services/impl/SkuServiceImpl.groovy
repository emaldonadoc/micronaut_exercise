package com.emc.warehouse.services.impl

import com.emc.warehouse.entities.Sku
import com.emc.warehouse.repositories.SkuRepository
import com.emc.warehouse.services.SkuService
import io.micronaut.runtime.context.scope.ThreadLocal

import javax.inject.Inject

@ThreadLocal
class SkuServiceImpl implements SkuService {

  @Inject
  private SkuRepository skuRepository
  
  @Override
  Sku fetchSkuById(Long id) {
    skuRepository.findById(id)
      .orElseThrow({ new RuntimeException('no sku found') })
  }

  @Override
  Sku saveSku() {
    return null
  }
}
