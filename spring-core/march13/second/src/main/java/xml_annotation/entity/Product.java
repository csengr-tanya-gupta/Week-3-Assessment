package xml_annotation.entity;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Product implements Serializable{
	@Value("1")
	private int id;
	@Value("ahah")
	private String name;
	@Value("apsara")
	private String brand;
	@Value("23.36")
	private double price;
	
}
