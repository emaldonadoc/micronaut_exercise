package com.emc.warehouse.exceptions

import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException

class SkuException extends HttpStatusException {
  SkuException(String message) {
    super(HttpStatus.CONFLICT, message)
  }
}
