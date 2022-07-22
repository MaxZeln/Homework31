package ru.learnup.learnup.spring.mvc.homework31.mapper;


import org.springframework.stereotype.Component;
import ru.learnup.learnup.spring.mvc.homework31.entity.Order_Details;
import ru.learnup.learnup.spring.mvc.homework31.model.OrderDetailsDto;
import ru.learnup.learnup.spring.mvc.homework31.view.OrderDetailsView;

@Component
public class OrderDetailsMapper {

    public final BookMapper bookMapper;
    public final AuthorMapper authorMapper;

    public OrderDetailsMapper(BookMapper bookMapper,
                              AuthorMapper authorMapper) {
        this.bookMapper = bookMapper;
        this.authorMapper = authorMapper;
    }


    public OrderDetailsDto mapToDto(Order_Details entity) {
        return OrderDetailsDto.builder()
                .id(entity.getId())
                .amount(entity.getAmount())
                .price(entity.getPrice())
                .book(bookMapper.mapToDto(entity.getBook()))
                .build();
    }

    public Order_Details mapToEntity(OrderDetailsDto dto) {
        Order_Details order_details = new Order_Details();
        order_details.setId(dto.getId());
        order_details.setAmount(dto.getAmount());
        order_details.setPrice(dto.getPrice());
        order_details.setBook(bookMapper.mapToEntity(dto.getBook()));
        return order_details;
    }

    public OrderDetailsView mapToView(OrderDetailsDto dto) {
        OrderDetailsView view = new OrderDetailsView();
        view.setId(dto.getId());
        view.setAmount(dto.getAmount());
        view.setPrice(dto.getPrice());
        view.setBook(bookMapper.mapToView(dto.getBook()));

        return view;
    }

    public OrderDetailsDto mapFromView(OrderDetailsView view) {
        return OrderDetailsDto.builder()
                .id(view.getId())
                .amount(view.getAmount())
                .price(view.getPrice())
                .book(bookMapper.mapFromView(view.getBook()))
                .build();
    }
}
