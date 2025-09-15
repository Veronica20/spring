package com.example.springboot.service;

import com.example.springboot.dto.SignupRequest;
import com.example.springboot.exception.EmailAlreadyExistsException;
import com.example.springboot.model.Member;
import com.example.springboot.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Member saveMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> getMemberByEmail(String email) {
        return memberRepository.findByEmail(email);
    }

    public Member registerMember(SignupRequest signupRequest) {

        if (memberRepository.findByEmail(signupRequest.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists!");
        }

        Member member = Member.builder()
                .firstName(signupRequest.getFirstName())
                .lastName(signupRequest.getLastName())
                .email(signupRequest.getEmail())
                .password(passwordEncoder.encode(signupRequest.getPassword())) // hash password!
                .build();

//        String hashedPassword = passwordEncoder.encode(rawPassword); // 👈 hash it
//        System.out.println("Hashed password = " + hashedPassword);
//        boolean matches = passwordEncoder.matches(rawPassword, hashedPassword);
//        matches() returns true if the entered password matches the saved one.

        return memberRepository.save(member);
    }
}
