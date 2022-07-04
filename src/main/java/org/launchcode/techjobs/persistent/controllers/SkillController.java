package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("skills")
public class SkillController {
    //index, displayAddSkillForm,processAddSkillForm,displayViewSkill
    @Autowired
        private SkillRepository skillRepository;



    @GetMapping("")
    public String index(Model model){
    model.addAttribute("title", "All Skills");
    model.addAttribute("skills",skillRepository.findAll());
    return "skills/index";
}
    @GetMapping("add")
    public String displayAddSkillForm(Model model){
        model.addAttribute("title", "Add Skill");
        model.addAttribute(new Skill());
        return "skills/add";
    }
    @PostMapping("add")
        public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill, Model model, Errors errors ){
            if(errors.hasErrors()){
                return "skills/add";
            }
            skillRepository.save(newSkill);
            return "redirect:";
        }

    @GetMapping("view/{skillId}")
    public String displayViewSkill(@PathVariable(required = false) Integer skillId, Model model){
    Optional<Skill> result= skillRepository.findById(skillId);
    if(result.isPresent()){
        Skill skill = (Skill)result.get();
        model.addAttribute("skill", skill);
        return "skills/view";
    }else{
        return "redirect:";


    }
    }
}
