package jpabook.jpashop.dto;

public record UpdateMemberRequest(
        String name
) {
    public static UpdateMemberRequest of(String name) {
        return new UpdateMemberRequest(name);
    }
}
