package org.springframework.samples.mvc.mapping;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@XmlRootElement
@Getter
@Setter
@ToString
public class JavaBean {

	private String foo = "bar";

	private String fruit = "apple";

}