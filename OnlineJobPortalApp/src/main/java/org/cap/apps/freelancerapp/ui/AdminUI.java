package org.cap.apps.freelancerapp.ui;

import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.adminms.service.AdminServiceImpl;
import org.cap.apps.freelancerapp.adminms.service.IAdminService;

public class AdminUI {
	private IAdminService adminservice = new AdminServiceImpl();

	public void runUi() {
		add("Ram", "Meheta", "root");

	}

	public Admin add(String firstName, String lastName, String Password) {
		Admin admin = new Admin(firstName, lastName, Password);
		admin = adminservice.save(admin);
		return admin;
	}

}
