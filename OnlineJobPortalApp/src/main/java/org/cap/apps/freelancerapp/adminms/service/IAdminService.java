package org.cap.apps.freelancerapp.adminms.service;

import org.cap.apps.freelancerapp.adminms.entities.Admin;

public interface IAdminService {
    Admin save(Admin admin);
    Admin update(Admin admin);
    Admin findById(Long id);

}
