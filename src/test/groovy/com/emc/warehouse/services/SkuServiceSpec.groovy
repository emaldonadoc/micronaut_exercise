package com.emc.warehouse.services

import com.emc.warehouse.entities.Sku
import com.emc.warehouse.exceptions.NotFoundException
import com.emc.warehouse.repositories.SkuRepository
import com.emc.warehouse.services.impl.SkuServiceImpl
import spock.lang.Specification

class SkuServiceSpec extends Specification {

  SkuService skuService

  SkuRepository skuRepository = Mock()

  def setup() {
    skuService = new SkuServiceImpl()
    skuService.skuRepository = skuRepository
  }

  def 'Should fetch sku by id'() {
    when:
      skuService.fetchSkuById(100L)

    then:
      1 * skuRepository.findById(100L) >> Optional.of(new Sku(description: 'test', id: 100))
      notThrown(NotFoundException)
  }

  def 'Should throw not found exception when find return null'() {
    when:
      skuService.fetchSkuById(100L)

    then:
      1 * skuRepository.findById(100L) >> Optional.ofNullable()
      thrown(NotFoundException)
  }
}
