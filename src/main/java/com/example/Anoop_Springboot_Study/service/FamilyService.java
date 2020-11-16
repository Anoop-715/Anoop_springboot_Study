package com.example.Anoop_Springboot_Study.service;

import com.example.Anoop_Springboot_Study.domain.DomainFamilyMembers;
import com.example.Anoop_Springboot_Study.model.FamilyMember;
import com.example.Anoop_Springboot_Study.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalLong;


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
          DomainFamilyMembers domainFamilyMember = new DomainFamilyMembers(familyMember.getName(),familyMember.getAge(),familyMember.getJob());
          return getFamilyMembersListFromDomainFamilyMembers(familyRepository.saveAndFlush(domainFamilyMember));
    }

    public Boolean UpdateFamilyMember(Long id,FamilyMember familyMember){
        try{
            DomainFamilyMembers domainFamilyMember =  familyRepository.getOne(id);
            domainFamilyMember.setName(familyMember.getName());
            domainFamilyMember.setJob(familyMember.getJob());
            domainFamilyMember.setAge(familyMember.getAge());
            familyRepository.saveAndFlush(domainFamilyMember);
            return  true;
        }
        catch(Exception e){
           return  false;
        }
    }

    public Boolean DeleteFamilyMember(Long id) {
        try {
            DomainFamilyMembers domainFamilyMember = familyRepository.getOne(id);
            familyRepository.delete(domainFamilyMember);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
        public Boolean PatchFamilyMember(Long id,FamilyMember familyMember){
            try{
                DomainFamilyMembers domainFamilyMember = familyRepository.getOne(id);
                domainFamilyMember.setAge(familyMember.getAge());
                familyRepository.saveAndFlush(domainFamilyMember);
                return  true;
            } catch(Exception e){
                return  false;
            }

        }


    private FamilyMember getFamilyMembersListFromDomainFamilyMembers(DomainFamilyMembers domainFamilyMember) {

       FamilyMember familyMemberObj = new FamilyMember();

       familyMemberObj.setId(domainFamilyMember.getId());
       familyMemberObj.setName(domainFamilyMember.getName());
       familyMemberObj.setJob(domainFamilyMember.getJob());
       familyMemberObj.setAge(domainFamilyMember.getAge());

       return  familyMemberObj;
    }


}
