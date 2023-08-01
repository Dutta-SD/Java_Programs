package org.local.easybank.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class Utilities {
    private final PasswordEncoder passwordEncoder;

    public String getEncodedPassword(final String rawString) {
        return passwordEncoder.encode(rawString);
    }
}
