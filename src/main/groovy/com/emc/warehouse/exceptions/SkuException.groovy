package com.emc.warehouse.exceptions

import groovy.transform.CompileStatic
import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException

@CompileStatic
class SkuException extends HttpStatusException {
  SkuException(String message) {
    super(HttpStatus.CONFLICT, message)
  }
}
