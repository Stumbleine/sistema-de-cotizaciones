package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.umss.dev.entity.QuotationBusiness;

@Repository

public interface QuotationBusinessRepository  extends JpaRepository<QuotationBusiness, Integer>{

}