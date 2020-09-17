package com.emc.warehouse.controllers

import com.emc.warehouse.dtos.SkuDto
import com.emc.warehouse.services.SkuService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Put
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

import javax.inject.Inject
import javax.validation.Valid

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
  HttpResponse saveSku(@Valid @Body SkuDto sku) {
    HttpResponse.created(skuService.saveSku(sku))
  }
}
