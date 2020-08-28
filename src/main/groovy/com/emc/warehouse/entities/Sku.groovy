package com.emc.warehouse.entities

import com.emc.warehouse.dtos.SkuDto
import com.emc.warehouse.enums.SkuType

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Sku {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id

  String description

  SkuType type

  Sku(SkuDto skuDto) {
    this.description = skuDto.description
    this.type - skuDto.type
  }
}
