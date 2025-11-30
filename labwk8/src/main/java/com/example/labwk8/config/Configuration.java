package com.example.labwk8.config;

import com.example.labwk8.model.*;
import com.example.labwk8.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner run(
            ContactRepository contactRepo,
            AssociationRepository associationRepo,
            MemberRepository memberRepo,
            DivisionRepository divisionRepo,
            EventRepository eventRepo,
            GuestRepository guestRepo,
            SpeakerRepository speakerRepo
    ) {
        return args -> {

            // --- PR CONTACT SYSTEM ---
            Name name = new Name();
            name.setSalutation("Mr.");
            name.setFirstName("John");
            name.setMiddleName("K.");
            name.setLastName("Doe");

            Contact contact = new Contact();
            contact.setCompany("PR Global");
            contact.setTitle("Manager");
            contact.setName(name);
            contactRepo.save(contact);

            // --- NURSE ASSOCIATION ---
            Association assoc = new Association();
            assoc.setName("Nurse Association of Spain");

            for (int i = 1; i <= 7; i++) {
                Member president = memberRepo.save(new Member(null, "President " + i, MemberStatus.ACTIVE, LocalDate.now()));

                Member member = memberRepo.save(new Member(null, "Member " + i, MemberStatus.ACTIVE, LocalDate.now()));

                Division div = new Division();
                div.setName("Division " + i);
                div.setDistrict("District " + ((i % 3) + 1));
                div.setPresident(president);
                div.getMembers().add(member);

                divisionRepo.save(div);
                assoc.getDivisions().add(div);
            }

            associationRepo.save(assoc);

            // --- EVENT SYSTEM ---
            Guest g1 = guestRepo.save(new Guest(null, "Guest A", GuestStatus.ATTENDING));
            Guest g2 = guestRepo.save(new Guest(null, "Guest B", GuestStatus.NO_RESPONSE));

            Speaker sp1 = speakerRepo.save(new Speaker(null, "Dr. Smith", 45));

            Conference conf = new Conference();
            conf.setTitle("Tech Summit 2025");
            conf.setDate(LocalDate.now());
            conf.setDuration(2);
            conf.setLocation("Madrid");
            conf.getGuests().add(g1);
            conf.getSpeakers().add(sp1);
            eventRepo.save(conf);

            Exhibition expo = new Exhibition();
            expo.setTitle("Health Expo");
            expo.setDate(LocalDate.now());
            expo.setDuration(1);
            expo.setLocation("Barcelona");
            expo.getGuests().add(g2);
            eventRepo.save(expo);

        };
    }
}
