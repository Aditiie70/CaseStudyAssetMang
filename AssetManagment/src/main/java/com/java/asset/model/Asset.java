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

public class Asset {
	private int id;
    private String assetNo;
    private String assetName;
    private String category;
    private String status;
    private int assignedTo;

}
