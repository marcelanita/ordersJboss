package org.lupiter.services;



import org.lupiter.domain.Product;
import org.lupiter.dto.OrderRequest;
import org.lupiter.dto.OrderResponse;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;



@Stateless
public class OrderServiceImpl  implements OrderService {

    @Inject
    private CacheService cacheService ;

    @Override
    public String addOrder(OrderRequest orderRequest) {
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setProductId(orderRequest.getProductId());
        orderResponse.setQuantity(orderRequest.getProductId());
        Product product = cacheService.getProductsCache().get(orderRequest.getProductId());
        if(product == null){
          return "Product not found !";
        }
        orderResponse.setProductTitle(product.getTitle());
        orderResponse.setPrice(product.getPrice());
        List<OrderResponse> orderDTOS = cacheService.getOrdersCache().get(orderRequest.getCustomerId());
        if(orderDTOS == null){
            orderDTOS = new ArrayList<>();
        }
        orderResponse.setId(orderDTOS.size()>0?orderDTOS.get(orderDTOS.size()-1).getId():1);
        orderDTOS.add(orderResponse);
        cacheService.getOrdersCache().put(orderRequest.getCustomerId(),orderDTOS);
        return "added order with id: " +orderResponse.getId();
    }

    @Override
    public List<OrderResponse> getOrderByCustomerId(int customerId) {
        List<OrderResponse> orderResponses = cacheService.getOrdersCache().get(customerId);
        if(orderResponses==null){
            orderResponses = new ArrayList<>();
        }
        return orderResponses;
    }
}
