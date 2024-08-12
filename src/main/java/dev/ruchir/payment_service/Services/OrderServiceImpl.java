package dev.ruchir.payment_service.Services;

import dev.ruchir.payment_service.DTOs.OrderDTO;
import dev.ruchir.payment_service.Models.Customer;
import dev.ruchir.payment_service.Models.Orders;
import dev.ruchir.payment_service.Repositories.CustomerRepository;
import dev.ruchir.payment_service.Repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Customer customer = customerRepository.findById(orderDTO.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        Orders order = new Orders();
        order.setOrderNumber(orderDTO.getOrderNumber());
        order.setTotalAmount(orderDTO.getTotalAmount());
        order.setCustomer(customer);
        Orders savedOrder = orderRepository.save(order);

        return mapToDTO(savedOrder);
    }

    @Override
    public OrderDTO getOrderById(Long id) {
        Orders order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return mapToDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO updateOrder(Long id, OrderDTO orderDTO) {
        Orders order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        order.setOrderNumber(orderDTO.getOrderNumber());
        order.setTotalAmount(orderDTO.getTotalAmount());
        Orders updatedOrder = orderRepository.save(order);

        return mapToDTO(updatedOrder);
    }

    @Override
    public void deleteOrder(Long id) {
        Orders order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        orderRepository.delete(order);
    }

    private OrderDTO mapToDTO(Orders order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderNumber(order.getOrderNumber());
        orderDTO.setTotalAmount(order.getTotalAmount());
        orderDTO.setCreatedAt(order.getCreatedAt());
        orderDTO.setCustomerId(order.getCustomer().getId());
        return orderDTO;
    }
}
