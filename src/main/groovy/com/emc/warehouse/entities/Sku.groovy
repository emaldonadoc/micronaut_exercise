package com.emc.warehouse.entities

import com.emc.warehouse.dtos.SkuDto
import com.emc.warehouse.enums.SkuType
import org.codehaus.groovy.runtime.InvokerHelper

import javax.persistence.*

@Entity
class Sku {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id

  String description

  @Enumerated(EnumType.STRING)
  SkuType type

  BigDecimal cost

  Sku() {}

  Sku(SkuDto skuDto) {
    InvokerHelper.setProperties(this, skuDto.properties)
  }
}
