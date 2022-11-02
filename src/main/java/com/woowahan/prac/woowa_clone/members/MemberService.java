package com.woowahan.prac.woowa_clone.members;

import com.woowahan.prac.woowa_clone.members.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public PostMemberRes create(PostMemberReq postMemberReq) {
        Long memberId = memberRepository.insert(postMemberReq);
        return new PostMemberRes(memberId, postMemberReq.getName(), postMemberReq.getEmail(), postMemberReq.getRole());
    }

    public List<GetMemberRes> findAll(GetMemberByNameReq getMemberByNameReq){
        List<GetMemberRes> getMemberRes=memberRepository.selectByName(getMemberByNameReq.getName());
        RoleType roleType=getMemberRes.get(0).getRole();
        if(roleType == RoleType.ADMIN)
            return memberRepository.selectAll();
        else
            return null;
    }
}
