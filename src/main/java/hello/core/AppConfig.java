package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * DIP와 OCP 정책을 위해서 AppConfig에서 구현객체를 생성 진행.
 * 각 클레스들은 철저하게 인터페이스를 의지한다.
 */
public class AppConfig {

    // MemberService DIP 설정. MemberServiceImpl을 실행하면서 MemberRepository를 설정함.
    // 생성자를 통해서 객체 주입. 생성자 주입
    // 멤버 서비스 정책
    public MemberService memberService(){
        return new MemberServiceImpl(MemberRepository());
    }

    // 멤버저장소 정책(DB 전달 가능)
    private MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    // 주문 서비스 정책
    public OrderService orderService(){
        return new OrderServiceImpl(MemberRepository(), discountPolicy());
    }

    // 할인 정책
    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
