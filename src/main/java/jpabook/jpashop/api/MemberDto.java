package jpabook.jpashop.api;

public record MemberDto(
        String name
) {
    public static MemberDto of(String name) {
        return new MemberDto(name);
    }
}
