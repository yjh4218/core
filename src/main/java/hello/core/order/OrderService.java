package hello.core.order;

public interface OrderService {

    //주문 정보 전달.
    Order createOrder(Long memberId, String itemId, int itemPrice);
}
