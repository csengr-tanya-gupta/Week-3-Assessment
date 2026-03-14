package xml_annotation.entity;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Project implements Serializable{
	@Value("1")
	private int id;
	@Value("whqt even")
	private String name;
	@Value("java ai based app")
	private String desc;
	
}
