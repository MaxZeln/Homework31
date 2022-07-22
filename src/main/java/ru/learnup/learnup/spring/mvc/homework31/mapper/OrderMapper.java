package ru.learnup.learnup.spring.mvc.homework31.mapper;

import org.springframework.stereotype.Component;
import ru.learnup.learnup.spring.mvc.homework31.entity.Order;
import ru.learnup.learnup.spring.mvc.homework31.model.OrderDto;
import ru.learnup.learnup.spring.mvc.homework31.view.OrderView;

@Component
public class OrderMapper {

    public final OrderDetailsMapper orderDetailsMapper;
    public final UserMapper userMapper;

    public OrderMapper(OrderDetailsMapper orderDetailsMapper,
                       UserMapper userMapper) {
        this.orderDetailsMapper = orderDetailsMapper;
        this.userMapper = userMapper;
    }

    public OrderDto mapToDto(Order entity) {
        return OrderDto.builder()
                .id(entity.getId())
                .purchase_amount(entity.getPurchase_amount())
                .user(userMapper.mapToDto(entity.getUser()))
                .order_detail(orderDetailsMapper.mapToDto(entity.getOrder_details()))
                .build();
    }

    public Order mapToEntity(OrderDto dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setPurchase_amount(dto.getPurchase_amount());
        order.setUser(userMapper.mapToEntity(dto.getUser()));
        order.setOrder_details(orderDetailsMapper.mapToEntity(dto.getOrder_detail()));
        return order;
    }

    public OrderView mapToView(OrderDto dto) {
        OrderView view = new OrderView();
        view.setId(dto.getId());
        view.setPurchase_amount(dto.getPurchase_amount());
        view.setUser(userMapper.mapToView(dto.getUser()));
        view.setOrder_detail(orderDetailsMapper.mapToView(dto.getOrder_detail()));
        return view;
    }

    public OrderDto mapFromView(OrderView view) {
        return OrderDto.builder()
                .id(view.getId())
                .purchase_amount(view.getPurchase_amount())
                .user(userMapper.mapFromView(view.getUser()))
                .order_detail(orderDetailsMapper.mapFromView(view.getOrder_detail()))
                .build();
    }
}
