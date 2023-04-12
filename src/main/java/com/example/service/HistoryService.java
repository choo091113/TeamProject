package com.example.service;

import com.example.dto.HistoryDTO;


import com.example.dto.ReplyDTO;
import com.example.entity.HistoryEntity;

import com.example.entity.ReplyEntity;
import com.example.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class HistoryService {
    private final HistoryRepository historyRepository;

    public List<HistoryDTO> findAllhistory() {
        List<HistoryEntity> historyEntityList = historyRepository.findAll();
        List<HistoryDTO> historyDTOList = new ArrayList<>();
        for (HistoryEntity historyEntity : historyEntityList) {
            historyDTOList.add(HistoryDTO.tohistoryDTO(historyEntity));

        }
        return historyDTOList;

    }

    public void savehistory(HistoryDTO historyDTO) {

        HistoryEntity historyEntity = HistoryEntity.toHistoryEntity(historyDTO);
        historyRepository.save(historyEntity);

    }

    public List<HistoryDTO> findAll() {
        List<HistoryEntity> historyEntityList = historyRepository.findAll();
        List<HistoryDTO> historyDTOList = new ArrayList<>();
        for (HistoryEntity historyEntity : historyEntityList) {
            historyDTOList.add(HistoryDTO.tohistoryDTO(historyEntity));
        }
        return historyDTOList;
    }

    public List<HistoryDTO> findAllByHistoryMemberid(int HistoryMemberid) {
        List<HistoryEntity> historyEntityList = historyRepository.findAllByHistoryMemberid(HistoryMemberid);
        List<HistoryDTO> historyDTOList = new ArrayList<>();
        for (HistoryEntity historyEntity : historyEntityList) {
            historyDTOList.add(HistoryDTO.tohistoryDTO(historyEntity));
        }
        return historyDTOList;
    }
}
