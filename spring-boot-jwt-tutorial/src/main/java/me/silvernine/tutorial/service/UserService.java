package me.silvernine.tutorial.service;

import lombok.RequiredArgsConstructor;
import me.silvernine.tutorial.dto.UserDto;
import me.silvernine.tutorial.entity.Authority;
import me.silvernine.tutorial.entity.AuthorityType;
import me.silvernine.tutorial.entity.User;
import me.silvernine.tutorial.exception.DuplicateMemberException;
import me.silvernine.tutorial.exception.NotFoundMemberException;
import me.silvernine.tutorial.repository.AuthorityRepository;
import me.silvernine.tutorial.repository.UserRepository;
import me.silvernine.tutorial.util.SecurityUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;


    @Transactional
    public UserDto signup(UserDto userDto) {
        if (userRepository.findOneWithAuthoritiesByUsername(userDto.getUsername()).orElse(null) != null) {
            throw new DuplicateMemberException("이미 가입되어 있는 유저입니다.");
        }


        User user = User.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .nickname(userDto.getNickname())
                .authorities(new HashSet<>())
                .activated(true)
                .build();

        authorityRepository.save(new Authority(user, AuthorityType.ROLE_USER));

        return UserDto.from(userRepository.save(user));
    }

    @Transactional(readOnly = true)
    public UserDto getUserWithAuthorities(String username) {
        return UserDto.from(userRepository.findOneWithAuthoritiesByUsername(username).orElse(null));
    }

    @Transactional(readOnly = true)
    public UserDto getMyUserWithAuthorities() {
        return UserDto.from(
                SecurityUtil.getCurrentUsername()
                        .flatMap(userRepository::findOneWithAuthoritiesByUsername)
                        .orElseThrow(() -> new NotFoundMemberException("Member not found"))
        );
    }
}
