package com.emc.warehouse.controllers

import com.emc.warehouse.dtos.SkuDto
import com.emc.warehouse.entities.Sku
import com.emc.warehouse.enums.SkuType
import com.emc.warehouse.services.SkuService
import io.micronaut.context.annotation.Factory
import io.micronaut.context.annotation.Replaces
import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject
import javax.inject.Singleton

@MicronautTest(environments = ['test'])
class SkuControllerIntegrationSpec extends Specification {

  @Inject
  private SkuService skuService

  @Inject
  @Client('/api/v1/warehouse')
  private RxHttpClient client

  def 'Should fetch sku by id'() {
    when:
      def result = client.toBlocking().retrieve(HttpRequest.GET('/sku/100'))

    then:
      result == '{"description":"test description","type":"FODDER","cost":1000}'
      1 * skuService.fetchSkuById(_) >> new SkuDto(cost: 1000, description: 'test description', type: SkuType.FODDER)

  }

  def 'Should save sku'() {
    given:
      def skuRequest = new SkuDto(cost: 1000, description: 'test description', type: SkuType.FODDER)
    when:
      def result = client.toBlocking().retrieve(HttpRequest.PUT('/sku', skuRequest), Sku)

    then:
      result.id == 1000
      1 * skuService.saveSku(_ as SkuDto) >> new Sku(id: 1000, cost: 1000, description: 'test description', type: SkuType.FODDER)
  }

  @Factory
  static class CustomTestConfiguration extends Specification {

    @Singleton
    @Replaces(bean = SkuService)
    SkuService skuService() {
      Mock(SkuService)
    }

  }
}
