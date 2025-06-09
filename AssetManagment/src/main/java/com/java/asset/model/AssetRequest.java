package com.java.asset.model;

import java.sql.Timestamp;

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

public class AssetRequest {
	
	 private int id;
	    private int employeeId;
	    private String assetName;
	    private String category;
	    private String status;
	    private Timestamp requestDate;
}
