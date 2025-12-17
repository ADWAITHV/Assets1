package com.asset.demo.repository;


import com.asset.demo.entity.AssetEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepo extends JpaRepository<AssetEntity, Long> {

    @Transactional
    @Modifying
    @Query(value ="update AssetEntity u set u.name=:name,u.description=:description,u.isActive=:isActive where u.id=:id")
    void updateAssets(@Param("name") String name,@Param("description") String description,@Param("isActive") boolean isActive, @Param("id") Long id);

}
