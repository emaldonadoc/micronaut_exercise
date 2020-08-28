package com.emc.warehouse.repositories.impl

import com.emc.warehouse.entities.Sku
import com.emc.warehouse.repositories.SkuRepository
import groovy.transform.CompileStatic

import javax.persistence.EntityManager
import javax.persistence.PersistenceContext
import javax.validation.constraints.NotNull

@CompileStatic
@Singleton(strict = false)
class SkuRepositoryImpl implements SkuRepository {

  @PersistenceContext
  private EntityManager entityManager;

  SkuRepositoryImpl(EntityManager entityManager) {
    this.entityManager = entityManager;
  }

  @Override
  Optional<Sku> findById(@NotNull Long id) {
    Optional.ofNullable(entityManager.find(Sku.class, id))
  }

  @Override
  Sku save(@NotNull Sku sku) {
    entityManager.persist(sku)
  }
}
