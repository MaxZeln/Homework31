package ru.learnup.learnup.spring.mvc.homework31.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnup.learnup.spring.mvc.homework31.entity.Order_Details;
import ru.learnup.learnup.spring.mvc.homework31.mapper.OrderDetailsMapper;
import ru.learnup.learnup.spring.mvc.homework31.model.OrderDetailsDto;
import ru.learnup.learnup.spring.mvc.homework31.repository.OrderDetailsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailsService {

    private final OrderDetailsRepository repository;
    private final OrderDetailsMapper orderDetailsMapper;

    public OrderDetailsService(OrderDetailsRepository repository,
                               OrderDetailsMapper orderDetailsMapper) {
        this.repository = repository;
        this.orderDetailsMapper = orderDetailsMapper;
    }

    public List<OrderDetailsDto> getOrderDetails() {
        return repository.findAll()
                .stream()
                .map(orderDetailsMapper::mapToDto)
                .collect(Collectors.toList());
    }

    public OrderDetailsDto findById(int id) {
        return orderDetailsMapper.mapToDto(repository.getById(id));
    }

    @Transactional
    public OrderDetailsDto createOrderDetails(OrderDetailsDto orderDetails) {
        Order_Details entity = orderDetailsMapper.mapToEntity(orderDetails);
        repository.save(entity);
        return orderDetailsMapper.mapToDto(entity);
    }

    public void delete(int id) {
        Order_Details order_details = repository.getById(id);
        repository.delete(order_details);
    }
}
