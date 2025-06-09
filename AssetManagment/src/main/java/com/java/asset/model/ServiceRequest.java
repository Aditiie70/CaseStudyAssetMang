package com.java.asset.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class ServiceRequest {
	
	private int id;
    private int assetId;
    private int employeeId;
    private String issueType;
    private String description;
    private String status;

}
