package com.asset.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

@RequestMapping
public class AssetController {


    @Autowired
    private AssetService assetService;


    @GetMapping("/auth/login")

    public String login(@RequestParam Long userName,@RequestParam String password){

        return assetService.login(userName,password);



    }
    @GetMapping("/auth/logout")

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
