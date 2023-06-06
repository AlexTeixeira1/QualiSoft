package com.mycompany.myapp.repository;

import com.mycompany.myapp.domain.DocumentPublicationProcess;
import java.util.Optional;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the DocumentPublicationProcess entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DocumentPublicationProcessRepository extends JpaRepository<DocumentPublicationProcess, Long> {
    Optional<DocumentPublicationProcess> findByProcessInstanceId(Long processInstanceId);
}
