package com.sprta.week04.service;

import com.sprta.week04.models.ItemDto;
import com.sprta.week04.models.Product;
import com.sprta.week04.models.ProductMypriceRequestDto;
import com.sprta.week04.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public Long update(Long id, ProductMypriceRequestDto requestDto) {
        Product product =productRepository.findById(id).orElseThrow(
                ()->new NullPointerException("아이디가 존재하지 않습니다.")
        );
        product.update(requestDto);
        return id;
    }
    @Transactional // 메소드 동작이 SQL 쿼리문임을 선언합니다.
    public Long updateBySearch(Long id, ItemDto itemDto) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );
        product.updateByItemDto(itemDto);
        return id;
    }
}
