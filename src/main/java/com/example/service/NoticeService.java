package com.example.service;




import com.example.dto.ItemDTO;
import com.example.dto.MemberDTO;
import com.example.dto.NoticeDTO;

import com.example.entity.ItemEntity;
import com.example.entity.MemberEntity;
import com.example.entity.NoticeEntity;
import com.example.repository.NoticeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class NoticeService {
    private final NoticeRepository noticeRepository;

    public List<NoticeDTO> findAllnotice() {
        List<NoticeEntity> noticeEntityList = noticeRepository.findAll();
        List<NoticeDTO> noticeDTOList = new ArrayList<>();
        for (NoticeEntity noticeEntity : noticeEntityList) {
            noticeDTOList.add(NoticeDTO.tonoticeDTO(noticeEntity));

        }
        return noticeDTOList;

    }

    public void savenotice(NoticeDTO noticeDTO) {
        // repository의 saveitem 메서드 호출
        NoticeEntity noticeEntity = NoticeEntity.toNoticeEntity(noticeDTO);
        noticeRepository.save(noticeEntity);
        // repository의 save 메서드 호출 (조건: entity객체를 넘겨줘야 함)
    }

    public void deleteById(Long noticeId) {
        noticeRepository.deleteById(noticeId);
    }

    public List<NoticeDTO> findAll() {
        List<NoticeEntity> noticeEntityList = noticeRepository.findAll();
        List<NoticeDTO> noticeDTOList = new ArrayList<>();
        for (NoticeEntity noticeEntity : noticeEntityList) {
            noticeDTOList.add(NoticeDTO.tonoticeDTO(noticeEntity));
        }
        return noticeDTOList;
    }
}
