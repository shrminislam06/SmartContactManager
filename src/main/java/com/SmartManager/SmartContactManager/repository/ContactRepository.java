package com.SmartManager.SmartContactManager.repository;

import com.SmartManager.SmartContactManager.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
}
