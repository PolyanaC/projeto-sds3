package com.dev.dsvendas.servicie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dev.dsvendas.dto.SaleDTO;
import com.dev.dsvendas.dto.SaleSuccessDTO;
import com.dev.dsvendas.dto.SaleSumDTO;
import com.dev.dsvendas.entities.Sale;
import com.dev.dsvendas.repositories.SaleRepository;
import com.dev.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;

	@Autowired
	private SellerRepository sellerRepository;

	// Lista paginada com Pageable
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		// Evita buscas repetidas dos vendedores na base de dados
		// Só funciona para poucos vendedores
		sellerRepository.findAll();
		Page<Sale> result = saleRepository.findAll(pageable);
		return result.map(sale -> new SaleDTO(sale));
	}

	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return saleRepository.amountGroupedBySeller();

	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return saleRepository.successGroupedBySeller();
	}

}
