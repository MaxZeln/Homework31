package ru.learnup.learnup.spring.mvc.homework31.controller;

import org.springframework.web.bind.annotation.*;
import ru.learnup.learnup.spring.mvc.homework31.mapper.OrderMapper;
import ru.learnup.learnup.spring.mvc.homework31.model.OrderDto;
import ru.learnup.learnup.spring.mvc.homework31.service.OrderService;
import ru.learnup.learnup.spring.mvc.homework31.view.OrderView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;

    public OrderController(OrderService orderService,
                           OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @GetMapping
    public List<OrderView> getOrders() {
        List<OrderDto> orders = orderService.getOrders();
        return orders
                .stream()
                .map(orderMapper::mapToView)
                .collect(Collectors.toList());
    }

    @GetMapping("/{orderId}")
    public OrderView getOrder(@PathVariable(name = "orderId")
                                          int orderId) {
    OrderDto order = orderService.findById(orderId);
    return  orderMapper.mapToView(order);
    }

    @PostMapping
    public OrderView createOrder(@RequestBody OrderView order) {
        OrderDto dto = orderMapper.mapFromView(order);
        return orderMapper.mapToView(
                orderService.createOrder(dto)
        );
    }

    @PutMapping("/{orderId}")
    public OrderView updateOrder(@PathVariable(name = "orderId")
                                             int orderId,
                                 @RequestBody OrderView order) {
        OrderDto dto = orderMapper.mapFromView(order);
        return  orderMapper.mapToView(
                orderService.createOrder(dto)
        );
    }

    @DeleteMapping("/{orderId}")
    public void delete(@PathVariable(name = "orderId")
                                   int orderId) {
        orderService.delete(orderId);
    }








}
