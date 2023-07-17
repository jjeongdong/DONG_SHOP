package com.example.dong_shop.item.service;

import com.example.dong_shop.item.entity.ItemImg;
import com.example.dong_shop.item.repository.ItemImgRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemImgService {

    @Value(value = "${itemImgLocation}")
    private String itemImgLocation;

    private final ItemImgRepository itemImgRepository;

    private final FileService fileService;

    public void saveItemImg(ItemImg itemImg, MultipartFile multipartFile) throws IOException {
        String oriImgName = multipartFile.getOriginalFilename();
        String imgName = "";
        String imgUrl = "";

        if (!StringUtils.isEmpty(oriImgName)) {
            imgName = fileService.uploadFile(itemImgLocation, oriImgName, multipartFile.getBytes());
            imgUrl = "/images/item/" + imgName;
        }

        itemImg.updateItemImg(oriImgName, imgName, imgUrl);
        itemImgRepository.save(itemImg);
    }

    public void updateItemImg(Long itemImgId, MultipartFile multipartFile) throws Exception{
        if(!multipartFile.isEmpty()){
            ItemImg savedItemImg = itemImgRepository.findById(itemImgId)
                    .orElseThrow(EntityNotFoundException::new);

            // 기존 이미지 파일 삭제
            if(!StringUtils.isEmpty(savedItemImg.getImgName())) {
                fileService.deleteFile(itemImgLocation+"/"+
                        savedItemImg.getImgName());
            }

            String oriImgName = multipartFile.getOriginalFilename();
            String imgName = fileService.uploadFile(itemImgLocation, oriImgName, multipartFile.getBytes());
            String imgUrl = "/images/item/" + imgName;

            savedItemImg.updateItemImg(oriImgName, imgName, imgUrl);
        }
    }

}
