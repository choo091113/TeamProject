package com.example.service;

import com.example.dto.ItemDTO;
import com.example.entity.ItemEntity;
import com.example.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import oracle.ucp.common.FailoverStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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
        }
        return itemDTOList;

    }
    public List<ItemDTO> findTop3ByOrderByIdDesc() {
        List<ItemEntity> itemEntityList = itemRepository.findTop3ByOrderByIdDesc();
        List<ItemDTO> itemDTOList = new ArrayList<>();
        for (ItemEntity itemEntity : itemEntityList) {
            itemDTOList.add(ItemDTO.toitemDTO(itemEntity));
        }
        return itemDTOList;
    }



    public ItemDTO findById(Long id) {
        Optional<ItemEntity> optionalItemEntity = itemRepository.findById(id);
        if(optionalItemEntity.isPresent()) {
            return ItemDTO.toitemDTO(optionalItemEntity.get());
        } else {
            return null;
        }
    }
    public List<ItemDTO> itemSearchList(String searchKeyword) {
        List<ItemEntity> itemEntityList = itemRepository.findByItemNameContaining(searchKeyword);
        List<ItemDTO> itemDTOList = new ArrayList<>();
        for (ItemEntity itemEntity : itemEntityList) {
            itemDTOList.add(ItemDTO.toitemDTO(itemEntity));
        }
        return itemDTOList;
    }
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }
}

