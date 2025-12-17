package com.asset.demo.controller;


import com.asset.demo.dto.UserRequestDto;
import com.asset.demo.entity.AssetEntity;
import com.asset.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping
public class AssetController {


    @Autowired
    private AssetService assetService;


    @PostMapping("/auth/login")

    public String login(@RequestBody UserRequestDto userRequestDto){

        return assetService.login(userRequestDto);



    }
    @PostMapping("/auth/logout")

    public String logout(){

        return "successfully logout";

    }
    @PostMapping("/createassets")
    public String createAssets(@RequestBody AssetEntity assetEntity){

        return assetService.createAssets(assetEntity);

    }
    @GetMapping("/getallassets")
    public List<AssetEntity> getAllAssets(){
        return assetService.getAllAssets();

    }
    @GetMapping("/assets/{id}")
    public Optional<AssetEntity> getAssetById(@PathVariable Long id){
        return assetService.getAssetById(id);

    }

    @PatchMapping("/updateassets/{id}")
    public String updateAssets(@RequestBody AssetEntity assetEntity,@PathVariable Long id){
        return assetService.updateAssets(assetEntity,id);

    }
    @DeleteMapping("/deleteassets/{id}")
    public String deleteAssets(@PathVariable Long id) {
        return assetService.deleteAssets(id);

    }







}
