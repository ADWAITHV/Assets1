package com.asset.demo.service;

import com.asset.demo.dto.UserRequestDto;
import com.asset.demo.repository.AssetRepo;
import com.asset.demo.repository.UserRepo;
import com.asset.demo.entity.AssetEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AssetServiceImpl implements AssetService {

    private final String nameo="adwaith";
    private final String passo="adwaith4431";

    @Autowired
    UserRepo userRepo;


    @Autowired
    AssetRepo assetRepo;


    @Override
    public String login(UserRequestDto userRequestDto) {

        Optional optional= userRepo.login(userRequestDto.getUserName(),userRequestDto.getPassword());
        if(optional.isEmpty())

            return "Login failed";

        else
          return "Login successfully done";

    }

    @Override
    public String createAssets(AssetEntity assetEntity) {
        assetRepo.save(assetEntity);
        return "assets saved successfully";


    }

    @Override
    public List<AssetEntity> getAllAssets() {

        return assetRepo.findAll();
    }
    @Override
    public Optional<AssetEntity> getAssetById(Long id) {

        return assetRepo.findById(id);
    }
    @Transactional
    @Override
    public String updateAssets(AssetEntity assetEntity, Long id) {
         assetRepo.updateAssets(assetEntity.getName(),assetEntity.getDescription(),assetEntity.isActive(),id);
        return "assets successfully updated";

    }

    @Override
    public String deleteAssets(Long id) {
        assetRepo.deleteById(id);
        return "Assets successfully deleted";
    }

    @Override
    public String login(String name, String pass, String ip) {


        ConcurrentHashMap<String, Integer> hashMap = new ConcurrentHashMap<>();

        if (name.equals(nameo)  && pass.equals(passo) ) {

            hashMap.put(ip, 1);

            return "login success";


        } else {

            int i = 1;

            if (hashMap.containsKey(ip)) {
                hashMap.put(ip, i++);

                Integer hashMap1 = hashMap.get(ip);
                if (hashMap1 == 5) {
                    return "suspended by 24 hours";
                } else {
                    return "login failed";
                }


            } else {
                hashMap.put(ip, 1);
                return "login failed";
            }


        }
    }
}



