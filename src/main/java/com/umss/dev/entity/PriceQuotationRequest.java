package com.umss.dev.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity(name = "PriceQuotationRequest" )
@Table(name = "PRICE_QUOTATON_REQUEST")

public class PriceQuotationRequest {
	
	@Id
	@GeneratedValue(strategy  = GenerationType.IDENTITY)
	private int idPriceQuotationRequest;
	
	@Column(length = 1000)
	private String link;
	
	@Column
	private Date deadline;
	
	/**/
	@OneToMany(mappedBy = "priceQuotationRequest",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JsonManagedReference
	private List<PriceQuotation> priceQuotations; 
	
	/**/
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name="idUserRole")
	@JsonBackReference
	private UserRole userRole;
	
	@JoinColumn(name = "idSpendingUnitRequest" )
	@OneToOne(cascade ={CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH} )
	//@JsonManagedReference
	private SpendingUnitRequest spendingUnitRequest;
	
	

	public SpendingUnitRequest getSpendingUnitRequest() {
		return spendingUnitRequest;
	}

	public void setSpendingUnitRequest(SpendingUnitRequest spendingUnitRequest) {
		this.spendingUnitRequest = spendingUnitRequest;
	}

	public int getIdPriceQuotationRequest() {
		return idPriceQuotationRequest;
	}

	public void setIdPriceQuotationRequest(int idPriceQuotationRequest) {
		this.idPriceQuotationRequest = idPriceQuotationRequest;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	

	public List<PriceQuotation> getPriceQuotations() {
		return priceQuotations;
	}

	public void setPriceQuotations(List<PriceQuotation> priceQuotations) {
		this.priceQuotations = priceQuotations;
	}

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	


	
	
	

}