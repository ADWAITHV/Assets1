package com.asset.demo.service;


import com.asset.demo.dto.UserRequestDto;
import com.asset.demo.entity.AssetEntity;

import java.util.List;
import java.util.Optional;


public interface AssetService {

    String login(UserRequestDto userRequestDto);

    String createAssets(AssetEntity assetEntity);

    List<AssetEntity> getAllAssets();

    Optional<AssetEntity> getAssetById(Long id);

    String updateAssets(AssetEntity assetEntity,  Long id);

    String deleteAssets(Long id);





}
