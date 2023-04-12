package com.example.service;

import com.example.dto.ItemDTO;
import com.example.dto.ReplyDTO;

import com.example.entity.ItemEntity;
import com.example.entity.ReplyEntity;
import com.example.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ReplyService {
    private final ReplyRepository replyRepository;

    public List<ReplyDTO> findAllreply() {
        List<ReplyEntity> replyEntityList = replyRepository.findAll();
        List<ReplyDTO> replyDTOList = new ArrayList<>();
        for (ReplyEntity replyEntity : replyEntityList) {
            replyDTOList.add(ReplyDTO.toreplyDTO(replyEntity));

        }
        return replyDTOList;

    }

    public void savereply(ReplyDTO replyDTO) {
        // repository의 saveitem 메서드 호출
        ReplyEntity replyEntity = ReplyEntity.toReplyEntity(replyDTO);
        replyRepository.save(replyEntity);
        // repository의 save 메서드 호출 (조건: entity객체를 넘겨줘야 함)
    }

    public void deleteById(Long replyId) {
        replyRepository.deleteById(replyId);
    }

    public List<ReplyDTO> findAll() {
        List<ReplyEntity> replyEntityList = replyRepository.findAll();
        List<ReplyDTO> replyDTOList = new ArrayList<>();
        for (ReplyEntity replyEntity : replyEntityList) {
            replyDTOList.add(ReplyDTO.toreplyDTO(replyEntity));
        }
        return replyDTOList;
    }
    public List<ReplyDTO> findAllByReplyItemId(int replyItemid) {
        List<ReplyEntity> replyEntityList = replyRepository.findAllByReplyItemid(replyItemid);
        List<ReplyDTO> replyDTOList = new ArrayList<>();
        for (ReplyEntity replyEntity : replyEntityList) {
            replyDTOList.add(ReplyDTO.toreplyDTO(replyEntity));
        }
        return replyDTOList;
    }


}
