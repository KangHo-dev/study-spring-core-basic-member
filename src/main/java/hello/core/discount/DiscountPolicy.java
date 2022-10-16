package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * // ctrl+x : 행 삭제
     * @return 할인 대상 금액
     */
    int discount(Member member, int price); // F2단축키 : 오류행으로 이동
}
