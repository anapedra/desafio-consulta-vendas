package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.devsuperior.dsmeta.dto.SaleDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import com.devsuperior.dsmeta.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SaleService {

	@Autowired
	private SaleRepository repository;
	@Autowired
	private SellerRepository sellerRepository;


	@Transactional(readOnly = true)
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}
     @Transactional(readOnly = true)
	public Page<SaleDTO> findAllSale(String minDate, String maxDate,String name, Pageable pageable){
		LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
		Page<Sale> page=repository.findAllSale(min,max,name,pageable);
		repository.findAllSales(page.stream().collect(Collectors.toList()));
		return page.map(SaleDTO::new);
	}
	@Transactional(readOnly = true)
	public List<SaleSummaryDTO> findSummary(String minDate, String maxDate){
		LocalDate today=LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		LocalDate min =minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max=maxDate.equals("") ? today : LocalDate.parse(maxDate);
		List<Sale> list=repository.findAllSummary(min,max);
		return list.stream().map(SaleSummaryDTO::new).collect(Collectors.toList());
	}



}
