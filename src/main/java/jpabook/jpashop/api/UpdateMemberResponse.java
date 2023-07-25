package jpabook.jpashop.api;

public record UpdateMemberResponse(
        Long id,
        String name
) {
    public static UpdateMemberResponse of(Long id, String name) {
        return new UpdateMemberResponse(id, name);
    }
}
