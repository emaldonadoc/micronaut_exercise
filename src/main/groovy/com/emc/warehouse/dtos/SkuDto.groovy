package com.emc.warehouse.dtos

import com.emc.warehouse.enums.SkuType

import javax.validation.constraints.NotNull

class SkuDto {
  @NotNull
  String description

  @NotNull
  SkuType type
}
