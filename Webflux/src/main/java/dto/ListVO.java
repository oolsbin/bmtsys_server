package dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Schema(description = "airport VO")
public class ListVO {
	
	@Schema(description = "에어라인아이디")
	private String airlineID;
	
	@Schema(description = "에어라인넘버")
	private String airlineNm;


//	lombok
	

}
