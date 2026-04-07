package com.example.lab.config;

import com.example.lab.entity.Association;
import com.example.lab.entity.Division;
import com.example.lab.entity.Member;
import com.example.lab.enums.MemberStatus;
import com.example.lab.repository.AssociationRepository;
import org.springframework.context.annotation.*;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.*;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner load(AssociationRepository repo) {
        return args -> {

            Association association = new Association();
            association.setName("Nurse Association of Spain");

            for (int i = 1; i <= 7; i++) {
                Division division = new Division();
                division.setName("Division " + i);
                division.setDistrict("District " + i);
                division.setAssociation(association);

                Member member = new Member();
                member.setName("Member " + i);
                member.setStatus(MemberStatus.ACTIVE);
                member.setRenewalDate(LocalDate.now());
                member.setDivision(division);

                division.getMembers().add(member);
                division.setPresident(member);

                association.getDivisions().add(division);
            }

            repo.save(association);
        };
    }
}