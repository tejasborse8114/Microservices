package ratingservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="ratings")
public class Rating {
	
	@Id
   private String ratingId;
   private String userId;
   private String hotelId;
   private String rating;
   private String feedback;
   
}
