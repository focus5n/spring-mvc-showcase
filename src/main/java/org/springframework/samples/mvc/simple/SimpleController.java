package org.springframework.samples.mvc.simple;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("ALL")
@RestController
public class SimpleController {

	@GetMapping("/simple")
	public String simple() {
		return "Hell SI!";
	}

}
