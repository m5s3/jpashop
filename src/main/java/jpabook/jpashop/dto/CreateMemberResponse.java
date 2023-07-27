package jpabook.jpashop.dto;

public record CreateMemberResponse(
        Long id
) {
    public static CreateMemberResponse of(Long id) {
        return new CreateMemberResponse(id);
    }
}
