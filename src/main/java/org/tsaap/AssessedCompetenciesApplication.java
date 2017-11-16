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
		System.out.println("ddfdfdfeeeeee");
		SpringApplication.run(AssessedCompetenciesApplication.class, args);
		System.out.println("fin");
	}

	@Bean
	public CommandLineRunner insertionsBdd() {
		System.out.println("debut insertions");
		Competence comp = new Competence();
		comp.setName("categorie1");
		comp.setDescription("Description categorie1");

		Category category = new Category();
		category.setName("category1");
		category.setDescription("Description category1");
		comp.setCategory(category);

		Catalog catalog = new Catalog();
		catalog.setName("catalog1");
		catalog.setDescription("description catalog1");
		comp.setCatalog(catalog);
		competenceService.saveCompetence(comp);

		System.out.println("fin insertions");
		return null;
	}
}
