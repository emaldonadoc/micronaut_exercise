package com.emc.warehouse.services

import com.emc.warehouse.dtos.SkuDto
import com.emc.warehouse.entities.Sku

interface SkuService {
  Sku fetchSkuById(Long id)

  Sku saveSku(SkuDto sku)
}