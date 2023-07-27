package jpabook.jpashop.dto;

public record MemberDto(
        String name
) {
    public static MemberDto of(String name) {
        return new MemberDto(name);
    }
}
