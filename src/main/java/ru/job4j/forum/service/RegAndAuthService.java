package ru.job4j.forum.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.job4j.forum.entity.User;

import ru.job4j.forum.repository.AuthorityRepository;
import ru.job4j.forum.repository.UserRepository;

@Service
public class RegAndAuthService {
    private final AuthorityRepository authorityRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public RegAndAuthService(AuthorityRepository authorityRepository, UserRepository userRepository, PasswordEncoder encoder) {
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Transactional
    public User save(User user) {
        user.setEnabled(true);
        user.setPassword(encoder.encode(user.getPassword()));
        user.setAuthority(authorityRepository.findByAuthority("ROLE_USER"));
        userRepository.save(user);
        return user;
    }
}
