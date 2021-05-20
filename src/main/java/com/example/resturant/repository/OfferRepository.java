package com.example.resturant.repository;

import com.example.resturant.model.offer;
import com.example.resturant.model.offerInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<offer, Integer> {

    @Query("SELECT new offerInfo(f.offerId,f.content,f.startDate,f.endDate,f.price,r.resturantName,m.mealName,r.resturantId,m.mealId) " +
            "  FROM offer f , resturant r, meal m where r.resturantId=f.resturantId and f.mealId=m.mealId ")
    public List<offerInfo> getOffersInfo();

    @Query("SELECT new offerInfo(f.offerId,f.content,f.startDate,f.endDate,f.price,r.resturantName,m.mealName,r.resturantId,m.mealId) " +
            "  FROM offer f , resturant r, meal m where r.resturantId=f.resturantId and f.mealId=m.mealId and f.offerId=?1 ")
    public offerInfo search(int key);

}
