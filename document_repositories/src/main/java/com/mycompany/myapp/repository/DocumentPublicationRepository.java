package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.DocumentPublication;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the DocumentPublication entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DocumentPublicationRepository extends JpaRepository<DocumentPublication, Long> {}
