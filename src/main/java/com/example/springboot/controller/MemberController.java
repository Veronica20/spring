package com.example.springboot.controller;

import com.example.springboot.dto.MemberResponseDto;
import com.example.springboot.dto.SignupRequest;
import com.example.springboot.model.Member;
import com.example.springboot.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }



    @GetMapping
    public List<MemberResponseDto> getAllUsers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{email}")
    public Optional<Member> getMByEmail(@PathVariable String email) {
        return memberService.getMemberByEmail(email);
    }
}

