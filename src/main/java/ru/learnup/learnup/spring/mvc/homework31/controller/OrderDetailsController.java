package ru.learnup.learnup.spring.mvc.homework31.controller;

import org.springframework.web.bind.annotation.*;
import ru.learnup.learnup.spring.mvc.homework31.mapper.OrderDetailsMapper;
import ru.learnup.learnup.spring.mvc.homework31.model.OrderDetailsDto;
import ru.learnup.learnup.spring.mvc.homework31.service.OrderDetailsService;
import ru.learnup.learnup.spring.mvc.homework31.view.OrderDetailsView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order_details")
public class OrderDetailsController {

    private final OrderDetailsService orderDetailsService;
    private final OrderDetailsMapper orderDetailsMapper;

    public OrderDetailsController(OrderDetailsService orderDetailsService,
                                  OrderDetailsMapper orderDetailsMapper) {
        this.orderDetailsService = orderDetailsService;
        this.orderDetailsMapper = orderDetailsMapper;
    }

    @GetMapping
    public List<OrderDetailsView> getOrderDetails() {
        List<OrderDetailsDto> orderDetails = orderDetailsService.getOrderDetails();
        return orderDetails
                .stream()
                .map(orderDetailsMapper::mapToView)
                .collect(Collectors.toList());
    }

    @GetMapping("/{order_detailsId}")
    public OrderDetailsView getOrderDetails(@PathVariable(name = "order_detailsId")
                                                        int order_detailsId) {
        OrderDetailsDto orderDetails = orderDetailsService.findById(order_detailsId);
        return orderDetailsMapper.mapToView(orderDetails);
    }

    @PostMapping
    public OrderDetailsView createOrderDetails(@RequestBody OrderDetailsView orderDetails) {
        OrderDetailsDto dto = orderDetailsMapper.mapFromView(orderDetails);
        return orderDetailsMapper.mapToView(
                orderDetailsService.createOrderDetails(dto)
        );
    }

    @PutMapping("/{order_detailsId}")
    public OrderDetailsView updateOrderDetails(@PathVariable(name = "order_detailsId")
                                                           int order_detailsId,
                                               @RequestBody OrderDetailsView orderDetails) {
        OrderDetailsDto dto = orderDetailsMapper.mapFromView(orderDetails);
        return orderDetailsMapper.mapToView(
                orderDetailsService.createOrderDetails(dto)
        );
    }

    @DeleteMapping("/{order_detailsId}")
    public void delete(@PathVariable(name = "order_detailsId")
                                   int order_detailsId) {
        orderDetailsService.delete(order_detailsId);
    }
}
