package jpabook.jpashop.api;

import jakarta.validation.Valid;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @GetMapping("/v2/members")
    public ResultDto member() {
        List<Member> findMembers = memberService.findMembers();
        List<MemberDto> collect = findMembers.stream()
                .map(it -> MemberDto.of(it.getName()))
                .collect(Collectors.toList());

        return new ResultDto(collect.size(), collect);
    }

    @Data
    @AllArgsConstructor
    static class ResultDto<T> {
        private int count;
        private T data;
    }

    @PostMapping("/v2/members")
    public CreateMemberResponse saveMember(@RequestBody @Valid CreateMemberRequest request) {
        Member member = new Member();
        member.setName(request.name());
        Long memberId = memberService.join(member);
        return CreateMemberResponse.of(memberId);
    }

    @PutMapping("/v2/members/{id}")
    public UpdateMemberResponse updateMember(
            @PathVariable Long id,
            @RequestBody @Valid UpdateMemberRequest request
    ) {
        memberService.update(id, request.name());
        Member member = memberService.findOne(id);
        return UpdateMemberResponse.of(member.getId(), member.getName());
    }
}
