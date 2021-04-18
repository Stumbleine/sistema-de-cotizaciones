package com.umss.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.*;


import com.umss.dev.entity.SpendingUnitRequest;
import com.umss.dev.output.CompleteSpendingUnitRequestOutput;

@Repository
public interface SpendingUnitRequestRepository extends JpaRepository<SpendingUnitRequest, Integer>{

}
