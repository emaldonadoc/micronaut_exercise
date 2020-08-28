package com.emc.warehouse.controllers

import com.emc.warehouse.entities.Sku
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Put
import io.micronaut.scheduling.TaskExecutors
import io.micronaut.scheduling.annotation.ExecuteOn

@Controller('/sku')
@ExecuteOn(TaskExecutors.IO)
class SkuController {

  @Get
  HttpResponse fetchSku() {
    HttpResponse.ok([message: 'aca andamos'])
  }

  @Put
  HttpResponse saveSku(@Body Sku sku) {
    HttpResponse.noContent()
  }
}
