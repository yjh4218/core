package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy; //DIP 지키기 위함.
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); //고정 할인
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); //변동 할인 //DIP, OCP 위반


    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    //주문 정보 생성. 회원 정보 조회 후 할인가격 확인, 주문정보 전달.
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);

    }
}
