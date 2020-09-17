package com.emc.warehouse.services

import com.emc.warehouse.dtos.SkuDto
import com.emc.warehouse.entities.Sku
import com.emc.warehouse.enums.SkuType
import com.emc.warehouse.exceptions.NotFoundException
import com.emc.warehouse.exceptions.SkuException
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
      def result = skuService.fetchSkuById(100L)

    then:
      result instanceof SkuDto
      1 * skuRepository.findById(100L) >> Optional.of(new Sku(description: 'test', id: 100, cost: 12.50, type: SkuType.DRYS))
      notThrown(NotFoundException)
  }

  def 'Should throw not found exception when find return null'() {
    when:
      skuService.fetchSkuById(100L)

    then:
      1 * skuRepository.findById(100L) >> Optional.ofNullable()
      thrown(NotFoundException)
  }

  def 'Shouldnt save sku already exists'() {
    given:
      def skuDto = new SkuDto(cost: 11.20, description: 'test sku', type: SkuType.CLEANING)

    when:
      skuService.saveSku(skuDto)

    then:
      1 * skuRepository.findByDescriptionAndType(skuDto.description, skuDto.type) >> Optional.ofNullable(new Sku())
      0 * skuRepository.save(_ as Sku) >> new Sku(skuDto)
      thrown(SkuException)
  }

  def 'Should save sku'() {
    given:
      def skuDto = new SkuDto(cost: 11.20, description: 'test sku', type: SkuType.CLEANING)

    when:
      skuService.saveSku(skuDto)

    then:
      1 * skuRepository.findByDescriptionAndType(skuDto.description, skuDto.type) >> Optional.ofNullable()
      1 * skuRepository.save(_ as Sku) >> new Sku(skuDto)
      notThrown(SkuException)
  }
}
