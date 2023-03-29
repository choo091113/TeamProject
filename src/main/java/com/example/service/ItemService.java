package com.example.service;

import com.example.dto.ItemDTO;
import com.example.entity.ItemEntity;
import com.example.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import oracle.ucp.common.FailoverStats;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<ItemDTO> findAllitem() {
        List<ItemEntity> itemEntityList = itemRepository.findAll();
        List<ItemDTO> itemDTOList = new ArrayList<>();
        for (ItemEntity itemEntity : itemEntityList) {
            itemDTOList.add(ItemDTO.toitemDTO(itemEntity));
            ItemDTO itemDTO = ItemDTO.toitemDTO(itemEntity);
            itemDTOList.add(itemDTO);
        }
        return itemDTOList;

    }


   /* public ItemDTO findByid(Long id) {
        Optional<ItemEntity> optionalItemEntity = itemRepository.findByid(id);
        if (optionalItemEntity.isPresent()) {
            return ItemDTO.toitemDTO(optionalItemEntity.get());
        } else {
            return null;
        }

        } */
}

