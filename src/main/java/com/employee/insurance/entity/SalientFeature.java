package com.employee.insurance.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Salient_Feature")
public class SalientFeature {

	@Id
	@NotNull(message = "salientFeatureId is required")
	@Column(name = "salient_feature_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long salientFeatureId;

	

	public Long getSalientFeatureId() {
		return salientFeatureId;
	}

	public void setSalientFeatureId(Long salientFeatureId) {
		this.salientFeatureId = salientFeatureId;
	}

	public String getPolicySalientFeature() {
		return policySalientFeature;
	}

	public void setPolicySalientFeature(String policySalientFeature) {
		this.policySalientFeature = policySalientFeature;
	}

	public AvailablePolicies getAvailablePolicies() {
		return availablePolicies;
	}

	public void setAvailablePolicies(AvailablePolicies availablePolicies) {
		this.availablePolicies = availablePolicies;
	}

	@NotNull(message = "policySalientFeature is required")
	@Column(name = "policy_salient_Feature")
	private String policySalientFeature;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policy_id")
	@JsonIgnore
	private AvailablePolicies availablePolicies;

}
