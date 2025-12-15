package com.asset.demo;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


public interface AssetService {

    String login(Long userName,String password);

    String createAssets(AssetEntity assetEntity);

    List<AssetEntity> getAllAssets();

    Optional<AssetEntity> getAssetById(Long id);

    String updateAssets(AssetEntity assetEntity,  Long id);

    String deleteAssets(Long id);





}
