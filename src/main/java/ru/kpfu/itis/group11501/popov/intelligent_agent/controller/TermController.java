package ru.kpfu.itis.group11501.popov.intelligent_agent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kpfu.itis.group11501.popov.intelligent_agent.model.Term;
import ru.kpfu.itis.group11501.popov.intelligent_agent.repository.TermRepository;

import java.util.List;

@Controller
public class TermController {

    private TermRepository termRepository;

    public TermController(TermRepository termRepository) {
        this.termRepository = termRepository;
    }

    @RequestMapping("/terms")
    @ResponseBody
    public List<Term> getTerms() {
        return termRepository.findAll();
    }

}
