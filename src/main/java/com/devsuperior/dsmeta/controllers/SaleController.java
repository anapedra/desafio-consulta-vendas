package com.devsuperior.dsmeta.controllers;

import com.devsuperior.dsmeta.dto.SaleDTO;
import com.devsuperior.dsmeta.dto.SaleSummaryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

@GetMapping(value = "/report")
public ResponseEntity<Page<SaleDTO>> findAll(
		@RequestParam(value = "minDate",defaultValue = "") String minDate,
		@RequestParam(value = "maxDate",defaultValue = "") String maxDate,
		@RequestParam(value = "name",defaultValue = "")String name,
		Pageable pageable) {
	Page<SaleDTO> page = service.findAllSale(minDate,maxDate,name.trim(),pageable);
	return ResponseEntity.ok().body(page);
}
	@GetMapping(value = "/summary")
	public ResponseEntity<List<SaleSummaryDTO>> findAllSummary(
			@RequestParam(value = "minDate",defaultValue = "") String minDate,
			@RequestParam(value = "maxDate",defaultValue = "") String maxDate) {
		List<SaleSummaryDTO> page = service.findSummary(minDate, maxDate);
		return ResponseEntity.ok().body(page);

	}


}
