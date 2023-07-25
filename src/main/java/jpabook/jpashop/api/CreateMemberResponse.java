package jpabook.jpashop.api;

import lombok.Data;

public record CreateMemberResponse(
        Long id
) {
    public static CreateMemberResponse of(Long id) {
        return new CreateMemberResponse(id);
    }
}
