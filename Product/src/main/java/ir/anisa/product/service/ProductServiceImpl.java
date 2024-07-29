package ir.anisa.product.service;

import ir.anisa.client.discount.CouponDTO;
import ir.anisa.client.discount.DiscountClient;
import ir.anisa.client.notification.NotificationClient;
import ir.anisa.client.notification.NotificationDTO;
import ir.anisa.product.dto.ProductDTO;
import ir.anisa.product.model.Product;
import ir.anisa.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper mapper;
    private final DiscountClient discountClient;
    private final NotificationClient notificationClient;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper, DiscountClient discountClient, NotificationClient notificationClient) {
        this.productRepository = productRepository;
        this.mapper = mapper;
        this.discountClient = discountClient;
        this.notificationClient = notificationClient;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = mapper.map(productDTO, Product.class);
        CouponDTO couponDTO = discountClient.findByCouponCode(productDTO.getCode());
        if (Objects.nonNull(couponDTO)) {
            BigDecimal subtract = new BigDecimal("100").subtract(couponDTO.getDiscount());
            product.setPrice(subtract.multiply(product.getPrice()).divide(new BigDecimal("100"), RoundingMode.UP));
        }
        Product savedProduct = productRepository.save(product);
        notificationClient.sendNotification(new NotificationDTO(savedProduct.getId(), String.format("product with id %s saved", savedProduct.getId())));
        return mapper.map(savedProduct, ProductDTO.class);
    }
}
