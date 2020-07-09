package com.employee.insurance.dto;
import java.util.List;

import com.employee.insurance.entity.SalientFeature;
public class AvailablePolicySalientFeatureResDto {
	private List<SalientFeature> salientFeatures;

	public List<SalientFeature> getSalientFeatures() {
		return salientFeatures;
	}

	public void setSalientFeatures(List<SalientFeature> salientFeatures) {
		this.salientFeatures = salientFeatures;
	}
}
