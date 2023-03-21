package com.example.service;

import com.example.dto.ItemDTO;
import com.example.entity.ItemEntity;
import com.example.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    public void saveitem(ItemDTO itemDTO) {
        // repository의 saveitem 메서드 호출
        ItemEntity itemEntity = ItemEntity.toItemEntity(itemDTO);
        itemRepository.save(itemEntity);
        // repository의 save 메서드 호출 (조건: entity객체를 넘겨줘야 함)
    }
}
