package com.example.labwk8.repository;

import com.example.labwk8.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {}

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByStatus(MemberStatus status);
}

public interface DivisionRepository extends JpaRepository<Division, Long> {
    List<Division> findByDistrict(String district);
}

public interface AssociationRepository extends JpaRepository<Association, Long> {}

public interface EventRepository extends JpaRepository<Event, Long> {}

public interface GuestRepository extends JpaRepository<Guest, Long> {
    List<Guest> findByStatus(GuestStatus status);
}

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {}
