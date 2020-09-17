package com.emc.warehouse.dtos

import com.emc.warehouse.entities.Sku
import com.emc.warehouse.enums.SkuType
import org.codehaus.groovy.runtime.InvokerHelper

import javax.validation.constraints.NotNull

class SkuDto {

  @NotNull
  String description

  @NotNull
  SkuType type

  BigDecimal cost

  SkuDto() {}

  SkuDto(Sku sku) {
    InvokerHelper.setProperties(this, sku.properties)
  }
}
