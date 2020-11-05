package org.cap.apps.freelancerapp.adminms.dao;

import org.cap.apps.freelancerapp.adminms.entities.Admin;

public interface IAdminDao {
   Admin save(Admin admin);
   Admin update(Admin admin);
   Admin findById(Long id);

}
