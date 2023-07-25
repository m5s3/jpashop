package jpabook.jpashop.api;

public record UpdateMemberRequest(
        String name
) {
    public static UpdateMemberRequest of(String name) {
        return new UpdateMemberRequest(name);
    }
}
