package com.emc.warehouse.exceptions

import groovy.transform.CompileStatic
import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException

@CompileStatic
class NotFoundException extends HttpStatusException {
  NotFoundException(String message) {
    super(HttpStatus.NOT_FOUND, message)
  }
}
