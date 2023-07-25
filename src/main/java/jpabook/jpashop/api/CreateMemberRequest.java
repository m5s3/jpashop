package jpabook.jpashop.api;

import jakarta.validation.constraints.NotEmpty;

public record CreateMemberRequest(
        @NotEmpty
        String name
) {
    public static CreateMemberRequest of(String name) {
        return new CreateMemberRequest(name);
    }
}
