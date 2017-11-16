package org.tsaap.competencies

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.validation.ConstraintViolationException

/**
 * Test competence service
 */
@ContextConfiguration
@SpringBootTest
class CompetenceServiceITest extends Specification {

    @Autowired
    private CompetenceService competenceService

    def "test save a valid catalog"() {
        given: "a valid catalog"
        Catalog catalog = new Catalog();
        catalog.setName("Catalog 1");
        catalog.setDescription("Description 1");

        when: "the catalog is saved"
        competenceService.saveCatalog(catalog);

        then: "the catalog has an id"
        catalog.getId() != null
        catalog.getName() == "Catalog 1"
        catalog.getDescription() == "Description 1"
    }

    def "test save a non valid catalog"() {
        given: "a non valid catalog"
        Catalog catalog = new Catalog();
        catalog.setName("C1");
        catalog.setDescription("Description 1");

        when: "the catalog is saved"
        competenceService.saveCatalog(catalog);

        then: "the a validation exception is thrown"
        thrown ConstraintViolationException
    }
    //---------Category
    def "test save a valid category"() {
        given: "a valid category"
        Category category = new Category();
        category.setName("Category 1");
        category.setDescription("Description 1");

        when: "the category is saved"
        competenceService.saveCategory(category);

        then: "the category has an id"
        category.getId() != null
        category.getName() == "Category 1"
        category.getDescription() == "Description 1"
    }

    def "test save a non valid category"() {
        given: "a non valid category"
        Category category = new Category();
        category.setName("C1");
        category.setDescription("Description 1");

        when: "the category is saved"
        competenceService.saveCategory(category);

        then: "the a validation exception is thrown"
        thrown ConstraintViolationException
    }

    //---------- Competence
    def "test save a valid competence"() {
        given: "a valid competence"
        Competence competence = new Competence();
        competence.setName("competence 1");
        competence.setDescription("Description 1");

        Category category = new Category();
        //category.setId(1L);
        category.setName("category");
        category.setDescription("Description 1");
        competence.setCategory(category);

        Catalog catalog = new Catalog();
        //catalog.setId(1L);
        catalog.setName("catalog");
        catalog.setDescription("Description Cat1");
        competence.setCatalog(catalog);

        when: "the competence is saved"
        competenceService.saveCompetence(competence);

        then: "the competence has an id"
        competence.getId() != null
        competence.getName() == "competence 1"
        competence.getDescription() == "Description 1"
        competence.getCatalog() != null
        competence.getCatalog().getId() != null
        competence.getCatalog().getName() == "catalog"
        competence.getCatalog().getDescription() == "Description Cat1"
        competence.getCategory()  != null
        competence.getCategory().getId() != null
        competence.getCategory().getName() == "category"
        competence.getCategory().getDescription() == "Description 1"
    }

    def "test save a non valid competence"() {
        given: "a non valid competence"
        Competence competence = new Competence();
        competence.setId(1L)
        competence.setName("Category 1");
        competence.setDescription("Description 1");
        competence.setCatalog(null);
        category.setId(1L);
        category.setName("category");
        category.setDescription("Description 1");
        competence.setCategory(category);
        when: "the competence is saved"
        competenceService.saveCompetence(competence);

        then: "the a validation exception is thrown"
        thrown ConstraintViolationException
    }


}
