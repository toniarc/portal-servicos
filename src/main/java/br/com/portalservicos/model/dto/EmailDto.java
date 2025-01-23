package br.com.portalservicos.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {

	private String to;
	private String subject;
	private Map<String, Object> templateModel;
	private String templateName;

}
