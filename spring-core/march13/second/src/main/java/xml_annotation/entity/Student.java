package xml_annotation.entity;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class Student implements Serializable{
	@Value("2")
	private int id;
	@Value("raji")
	private String name;
	@Value("ra@mail")
	private String mailId;
	@Value("236541456")
	private long contactNum;
	@Autowired
	private Project project;
	
}
