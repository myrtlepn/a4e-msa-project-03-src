package bymin4.share.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductDto {

	private Long id;
	private String name;
	private Integer price;
	private List<ReviewDto> reviews;

}
