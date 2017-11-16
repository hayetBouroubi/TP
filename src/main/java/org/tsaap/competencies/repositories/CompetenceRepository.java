package org.tsaap.competencies.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.tsaap.competencies.Competence;

/**
 * Catalog repository
 */
@Transactional
public interface CompetenceRepository extends CrudRepository<Competence,Long> {
}
