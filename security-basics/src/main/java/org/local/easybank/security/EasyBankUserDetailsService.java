package org.local.easybank.security;

import lombok.RequiredArgsConstructor;
import org.local.easybank.entity.EasyBankUser;
import org.local.easybank.repository.EasyBankUserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EasyBankUserDetailsService implements UserDetailsService {

    private final EasyBankUserRepository easyBankUserRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        List<EasyBankUser> listOfUsers = easyBankUserRepository.findByEmail(email);
        if (listOfUsers.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User with Email: %s not found", email));
        }

        EasyBankUser userFound = listOfUsers.get(0);

        return User.builder()
                .username(userFound.getEmail())
                .password(userFound.getPassword())
                .authorities(List.of(new SimpleGrantedAuthority(userFound.getRole()
                                                                        .name())))
                .build();
    }
}
