package com.emc.warehouse.repositories

import com.emc.warehouse.entities.Sku
import com.emc.warehouse.enums.SkuType
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class SkuRepositorySpec extends Specification {

  @Inject
  SkuRepository skuRepository

  Sku sku

  def setup() {
    sku = new Sku(cost: 125.25, description: 'test', type: SkuType.CLEANING)
  }

  def 'Should save a sku'() {
    when:
      def result = skuRepository.save(sku)

    then:
      result.id
  }

  def 'Should get sku by description and type'() {
    given:
      skuRepository.save(sku)

    when:
      def result = skuRepository.findByDescriptionAndType(sku.description, sku.type).get()

    then:
      result.cost == sku.cost
  }
}
