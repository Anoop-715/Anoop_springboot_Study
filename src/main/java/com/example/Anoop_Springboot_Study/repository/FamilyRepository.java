package com.example.Anoop_Springboot_Study.repository;

import com.example.Anoop_Springboot_Study.domain.DomainFamilyMembers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyRepository extends JpaRepository<DomainFamilyMembers, Long> {

}

