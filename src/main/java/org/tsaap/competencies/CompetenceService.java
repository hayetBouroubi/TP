package org.tsaap.competencies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tsaap.competencies.repositories.CatalogRepository;
import org.tsaap.competencies.repositories.CategoryRepository;
import org.tsaap.competencies.repositories.CompetenceRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Service to manage competencies
 */
@Service
public class CompetenceService {

    @Autowired
    private CatalogRepository catalogRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private CompetenceRepository competenceRepository;

    public CompetenceService(CatalogRepository catalogRepository, CategoryRepository categoryRepository, CompetenceRepository competenceRepository ) {
        this.catalogRepository = catalogRepository ;
        this.categoryRepository = categoryRepository;
        this.competenceRepository = competenceRepository;
    }

   	/**
     * Save catalog in the database
     * @param catalog the catalog to save
     * @return the catalog
     */
    public Catalog saveCatalog(Catalog catalog) {
        Catalog res =  catalogRepository.save(catalog);
        return res;
    }
    
    
    /**
     * Save category in the database
     * @param category the category to save
     * @return the category
     */
    public Category saveCategory(Category category) {
    	Category res =  categoryRepository.save(category);
        return res;
    }
    
    /**
     * Save competence in the database
     * @param competence the competence to save
     * @return the competence
     */
    public Competence saveCompetence(Competence competence) {
        if(competence.getCatalog() != null){
            Catalog catalog =  catalogRepository.save(competence.getCatalog());
            competence.setCatalog(catalog);
        }
        if(competence.getCategory() != null){
            Category category =  categoryRepository.save(competence.getCategory());
            competence.setCategory(category);
        }
    	Competence res =  competenceRepository.save(competence);
        return res;
    }


    public List<Competence> findAllCompetences(){
        List<Competence> res = (List<Competence>) competenceRepository.findAll();
        return res;
    }
}
