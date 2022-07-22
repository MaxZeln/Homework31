package ru.learnup.learnup.spring.mvc.homework31.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.learnup.spring.mvc.homework31.entity.Order;
import ru.learnup.learnup.spring.mvc.homework31.mapper.OrderMapper;
import ru.learnup.learnup.spring.mvc.homework31.model.OrderDto;
import ru.learnup.learnup.spring.mvc.homework31.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository repository;
    private final OrderMapper orderMapper;

    public OrderService(OrderRepository repository, OrderMapper orderMapper) {
        this.repository = repository;
        this.orderMapper = orderMapper;
    }

    public List<OrderDto> getOrders() {
        return repository.findAll()
                .stream()
                .map(orderMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public OrderDto findById(int id) {
        return orderMapper.mapToDto(repository.getById(id));
    }

    @Transactional
    public OrderDto createOrder(OrderDto order) {
        Order entity = orderMapper.mapToEntity(order);
        repository.save(entity);
        return orderMapper.mapToDto(entity);
    }

    public void delete(int id) {
        Order order = repository.getById(id);
        repository.delete(order);
    }
}
