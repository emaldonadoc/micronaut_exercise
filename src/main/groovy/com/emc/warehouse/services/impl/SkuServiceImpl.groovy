package com.emc.warehouse.services.impl

import com.emc.warehouse.dtos.SkuDto
import com.emc.warehouse.entities.Sku
import com.emc.warehouse.exceptions.NotFoundException
import com.emc.warehouse.exceptions.SkuException
import com.emc.warehouse.repositories.SkuRepository
import com.emc.warehouse.services.SkuService

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SkuServiceImpl implements SkuService {

  @Inject
  private SkuRepository skuRepository

  private void findSkuByTypeAndDescription(SkuDto skuDto) {
    skuRepository.findByDescriptionAndType(skuDto.description, skuDto.type)
      .ifPresent({
        throw new SkuException('Sku already exists')
      })
  }

  @Override
  SkuDto fetchSkuById(Long id) {
    new SkuDto(
      skuRepository.findById(id)
        .orElseThrow({ new NotFoundException('no sku found') })
    )
  }

  @Override
  Sku saveSku(SkuDto sku) {
    findSkuByTypeAndDescription(sku)
    skuRepository.save(new Sku(sku))
  }
}
