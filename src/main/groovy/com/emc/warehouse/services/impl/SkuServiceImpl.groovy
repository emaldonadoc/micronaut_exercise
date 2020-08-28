package com.emc.warehouse.services.impl

import com.emc.warehouse.dtos.SkuDto
import com.emc.warehouse.entities.Sku
import com.emc.warehouse.exceptions.NotFoundException
import com.emc.warehouse.repositories.SkuRepository
import com.emc.warehouse.services.SkuService

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SkuServiceImpl implements SkuService {

  @Inject
  private SkuRepository skuRepository

  @Override
  Sku fetchSkuById(Long id) {
    skuRepository.findById(id)
      .orElseThrow({ new NotFoundException('no sku found') })
  }

  @Override
  Sku saveSku(SkuDto sku) {
    skuRepository.save(new Sku(sku))
  }
}
