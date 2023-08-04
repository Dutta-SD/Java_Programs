package org.local.easybank.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.local.easybank.entity.EasyBankUser;
import org.local.easybank.repository.EasyBankUserRepository;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
@Log4j2
public class EazyBankUsernamePasswordAuthenticationProvider implements AuthenticationProvider {
    private final PasswordEncoder passwordEncoder;
    private final EasyBankUserRepository easyBankUserRepository;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String rawPassword = authentication.getCredentials()
                .toString();
        List<EasyBankUser> users = easyBankUserRepository.findByEmail(userName);

        if (!users.isEmpty()) {
            EasyBankUser user = users.get(0);
            if (passwordEncoder.matches(rawPassword, user.getPassword())) {
                log.info("{} is a valid user.", userName);
                return new UsernamePasswordAuthenticationToken(userName, rawPassword,
                                                               List.of(new SimpleGrantedAuthority(user.getRole()
                                                                                                          .name())));
            } else {
                throw new BadCredentialsException("Username or Password is Invalid");
            }
        }
        throw new BadCredentialsException("Username not found");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}
