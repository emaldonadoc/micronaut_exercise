package com.emc.warehouse.controllers

import com.emc.warehouse.entities.Sku
import com.emc.warehouse.services.SkuService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Put
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

import javax.inject.Inject

@Controller('/sku')
@ExecuteOn(TaskExecutors.IO)
class SkuController {

  @Inject
  private SkuService skuService

  @Get('/{id}')
  HttpResponse fetchSku(Long id) {
    HttpResponse.ok(skuService.fetchSkuById(id))
  }

  @Put
  HttpResponse saveSku(@Body Sku sku) {
    HttpResponse.noContent()
  }
}
