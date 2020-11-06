package org.cap.apps.freelancerapp.adminms.repository;

import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAdminRepository extends JpaRepository<Admin, Long> {
    Admin findAdminByName(String firstName, String lastName);
}

