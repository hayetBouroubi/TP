package org.tsaap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.tsaap.competencies.Catalog;
import org.tsaap.competencies.Category;
import org.tsaap.competencies.Competence;
import org.tsaap.competencies.CompetenceService;

@SpringBootApplication
public class AssessedCompetenciesApplication {

	@Autowired
	private CompetenceService competenceService;

	public static void main(String[] args) {
		SpringApplication.run(AssessedCompetenciesApplication.class, args);
	}

	@Bean
	public CommandLineRunner insertionsBdd() {
		System.out.println("debut insertions");
		Competence comp = new Competence();
		comp.setName("Competence1");
		comp.setDescription("Description Competence1");

		Category category = new Category();
		category.setName("category1");
		category.setDescription("Description category1");
		comp.setCategory(category);

		Catalog catalog = new Catalog();
		catalog.setName("catalog1");
		catalog.setDescription("description catalog1");
		comp.setCatalog(catalog);
		competenceService.saveCompetence(comp);
		
		Competence comp2 = new Competence();
		comp2.setName("Competence2");
		comp2.setDescription("Description Competence2");

		Category category2 = new Category();
		category2.setName("category2");
		category2.setDescription("Description category2");
		comp2.setCategory(category2);

		Catalog catalog2 = new Catalog();
		catalog2.setName("catalog2");
		catalog2.setDescription("description catalog2");
		comp2.setCatalog(catalog2);
		comp2etenceService.saveCompetence(comp2);

		System.out.println("fin insertions");
		return null;
	}
}
