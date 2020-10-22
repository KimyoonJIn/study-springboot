package com.example.app;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Argument {
	private final int a;
	private final int b;
}
