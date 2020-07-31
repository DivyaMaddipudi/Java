package com.maven.Interfaces;

import org.springframework.stereotype.Component;

import com.interfaces.car.Cars;


@Component("celerio")
public class Celerio implements Cars {

	public String cars() {
		
		return "Celerio methods";
	}

}
