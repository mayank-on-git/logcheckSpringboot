package com.logcheck.logcheck.Repository;

import com.logcheck.logcheck.entity.Demo_Details;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Demo_DetailsRepository extends JpaRepository<Demo_Details,Long> {
}
