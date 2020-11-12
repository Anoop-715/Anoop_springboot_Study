package com.example.Anoop_Springboot_Study.controller;

import com.example.Anoop_Springboot_Study.model.FamilyMember;
import com.example.Anoop_Springboot_Study.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/familymembers")
    public List<FamilyMember> getAllFamilyMembers(){
        return familyService.getFamilyMembersList();
    }

    @PostMapping("/addfamilymember")
    public FamilyMember addFamilyMember(@Valid @RequestBody FamilyMember familyMember){
        return familyService.addFamilyMember(familyMember);
    }


}
