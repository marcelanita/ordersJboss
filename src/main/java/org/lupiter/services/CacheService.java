package org.lupiter.services;

import org.lupiter.domain.Product;
import org.lupiter.dto.OrderResponse;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Stateless
public class CacheService {


    Map<Integer, List<OrderResponse>> ordersCache = new ConcurrentHashMap<>();
    Map<Integer, Product> productsCache = new ConcurrentHashMap<>();

   @PostConstruct
   public void populateProductCache(){
       Product product1 = new Product(1,"apple",new BigDecimal(10));
       productsCache.put(product1.getId(),product1);
       Product product2 = new Product(2,"pear",new BigDecimal(20));
       productsCache.put(product2.getId(),product2);
       Product product3 = new Product(3,"lemon",new BigDecimal(30));
       productsCache.put(product3.getId(),product3);
   }


    public Map<Integer, List<OrderResponse>> getOrdersCache() {
        return ordersCache;
    }

    public void setOrdersCache(Map<Integer, List<OrderResponse>> ordersCache) {
        this.ordersCache = ordersCache;
    }

    public Map<Integer, Product> getProductsCache() {
        return productsCache;
    }

    public void setProductsCache(Map<Integer, Product> productsCache) {
        this.productsCache = productsCache;
    }
}
