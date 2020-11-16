package com.example.Anoop_Springboot_Study.controller;

import com.example.Anoop_Springboot_Study.exception.ApiRequestException;
import com.example.Anoop_Springboot_Study.model.FamilyMember;
import com.example.Anoop_Springboot_Study.service.FamilyService;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private FamilyService familyService;

    @GetMapping("/familymembers")
    public List<FamilyMember> getAllFamilyMembers(){
        throw new ApiRequestException("Oops Cannot get all students with custom exception.");
//        return familyService.getFamilyMembersList();
    }

    @PostMapping("/addfamilymember")
    public FamilyMember addFamilyMember(@Valid @RequestBody FamilyMember familyMember){
        return familyService.addFamilyMember(familyMember);
    }

    @PutMapping("/updatefamilymember/{id}")
    public Boolean updateFamilyMember(@PathVariable(value = "id") Long id,@Valid @RequestBody FamilyMember familyMember){
        return familyService.UpdateFamilyMember(id,familyMember);
    }

    @DeleteMapping("/deletefamilymember/{id}")
    public  Boolean deleteFamilyMember(@PathVariable(value = "id") Long id){
        return familyService.DeleteFamilyMember(id);
    }

    @PatchMapping("/patchfamily/{id}")
    public Boolean patchFamily(@PathVariable(value = "id") Long id, @RequestBody FamilyMember familyMember ){
        return  familyService.PatchFamilyMember(id,familyMember);
    }



}
