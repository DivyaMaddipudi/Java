package com.maven.Interfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.interfaces.car.Cars;


@Component
public class Celerio implements Cars {

	public String cars() {
		return "Celerio methods";
	}

}
