package org.cap.apps.freelancerapp.adminms.service;

import javax.transaction.Transactional;

import org.cap.apps.freelancerapp.adminms.dao.IAdminDao;
import org.cap.apps.freelancerapp.adminms.entities.Admin;
import org.cap.apps.freelancerapp.exceptions.AdminNotFoundException;
import org.cap.apps.freelancerapp.exceptions.InvalidAdminNameException;
import org.cap.apps.freelancerapp.adminms.repository.IAdminRepository;
import org.cap.apps.freelancerapp.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Transactional
@Service
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private IAdminRepository adminRepository;

	@Autowired
	private IAdminDao admindao;

	@Override
	public Admin save(Admin admin) {
		ValidationUtil.checkArgumentNotNull(admin);
		ValidationUtil.checkFirstName(admin.getFirstName());
		ValidationUtil.checkLastName(admin.getLastName());
		admin = admindao.save(admin);
		if (admin == null) {
			throw new InvalidAdminNameException("Admin name not found=" + admin);
		}
		return admin;
	}

	@Override
	public Admin findById(Long id) {
		Optional<Admin>optional = adminRepository.findById(id);
		if(!optional.isPresent()) {
			throw new AdminNotFoundException("admin not found for id = " + id);
		}
		return optional.get();
	}

	@Override
	public Admin update(Admin admin){
		admin = admindao.update(admin);
		return admin;
	}

}
