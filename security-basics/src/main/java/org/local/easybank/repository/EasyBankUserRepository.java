package org.local.easybank.repository;

import org.local.easybank.entity.EasyBankUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EasyBankUserRepository extends CrudRepository<EasyBankUser, Long> {

    List<EasyBankUser> findByEmail(String email);
}
