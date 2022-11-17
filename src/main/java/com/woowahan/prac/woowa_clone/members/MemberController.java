package com.woowahan.prac.woowa_clone.members;

import com.woowahan.prac.woowa_clone.members.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//REST API annotation or ResponseBody
@RequiredArgsConstructor
//final이 붙은 field들의 생성자 생성 -- this.객체=객체 대체
@RequestMapping("/members")
//webpage의 상위 이름
public class MemberController {

    private final MemberService memberService;
    private final MemberRepository memberRepository;


    //요청으로 들어오는 것을 매개변수로 받겠음
    @PostMapping("/signup") //members/new -- create
    public PostMemberRes join(@RequestBody PostMemberReq postMemberReq) {
        return memberService.create(postMemberReq);
    }

    /*
    기존: jsp로 웹페이지 직접 연결
    rest: 데이터 자체를 전달  ResponseBody
     */

    //관리자만 접근 가능
    @GetMapping("") //read
    public List<GetMemberRes> findAll(@RequestBody GetMemberByNameReq getMemberByNameReq) {
        return memberService.findAll(getMemberByNameReq);
    }

    /* {member_id}
    @pathvariable("member_id") Long memberid  들어온 "" 을 --애 저장하겠음음
     */

    @GetMapping("/info")
    public GetMemberRes findByName(@RequestBody GetMemberByNameReq getMemberByNameReq) {
        return memberRepository.selectByName(getMemberByNameReq.getName());
    }

    //login
    @GetMapping("/login")
    public String loginByNamePw(@RequestBody GetMemberByNamePwReq getMemberByNamePwReq){
        return memberRepository.selectByNamePw(getMemberByNamePwReq);
    }

    //비밀번호 변경
    @PatchMapping("/update")//update modify
    public String update(@RequestBody PatchMemberByPwReq patchMemberByPwReq){
        return memberRepository.updatePw(patchMemberByPwReq);
    }
}
