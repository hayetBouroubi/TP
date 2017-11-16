package org.tsaap.competencies;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WebService {

    @Autowired
    private CompetenceService competenceService;

    @RequestMapping("/competences")
    public List<Competence> findAll() {
        return competenceService.findAllCompetences();
    }


}
