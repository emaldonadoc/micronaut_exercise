package com.emc.warehouse.exceptions

import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException

class NotFoundException extends HttpStatusException {
  NotFoundException(String message) {
    super(HttpStatus.NOT_FOUND, message)
  }
}
