package org.lupiter.services;
import org.lupiter.dto.OrderRequest;
import org.lupiter.dto.OrderResponse;

import javax.ejb.Local;
import java.util.List;

@Local
public interface OrderService {
    public String addOrder(OrderRequest orderRequest) ;

    public List<OrderResponse> getOrderByCustomerId(int customerId) ;
}
