package com.example.Anoop_Springboot_Study.service;

import com.example.Anoop_Springboot_Study.domain.DomainFamilyMembers;
import com.example.Anoop_Springboot_Study.model.FamilyMember;
import com.example.Anoop_Springboot_Study.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    List<FamilyMember> familyMembers = new ArrayList<>();

    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }


    public List<FamilyMember> getFamilyMembersList(){
        List<FamilyMember> modelFamilyMembers = new ArrayList<>();
        List<DomainFamilyMembers> domainFamilyMembers = familyRepository.findAll() ;
        for (DomainFamilyMembers domainFamilyMember :domainFamilyMembers) {
            modelFamilyMembers.add(getFamilyMembersListFromDomainFamilyMembers(domainFamilyMember));
        }
        return modelFamilyMembers;
    }


    public FamilyMember addFamilyMember(FamilyMember familyMember){
          DomainFamilyMembers domainFamilyMember = new DomainFamilyMembers(familyMember.getName(),familyMember.getJob(),familyMember.getAge());
          return getFamilyMembersListFromDomainFamilyMembers(familyRepository.saveAndFlush(domainFamilyMember));
    }


    private FamilyMember getFamilyMembersListFromDomainFamilyMembers(DomainFamilyMembers domainFamilyMember) {
       FamilyMember familyMemberObj = new FamilyMember();

       familyMemberObj.setId(domainFamilyMember.getId());
       familyMemberObj.setAge(domainFamilyMember.getAge());
       familyMemberObj.setName(domainFamilyMember.getName());
        familyMemberObj.setJob(domainFamilyMember.getJob());
       return  familyMemberObj;
    }


}
