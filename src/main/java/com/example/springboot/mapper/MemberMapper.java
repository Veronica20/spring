package com.example.springboot.mapper;

import com.example.springboot.dto.MemberResponseDto;
import com.example.springboot.model.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {
    public MemberResponseDto toDto(Member entity) {
        MemberResponseDto dto = new MemberResponseDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        return dto;
    }
}
