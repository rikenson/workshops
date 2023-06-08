package com.mendoz.workshop;

import com.mendoz.workshop.payload.WorkshopResponse;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;



class AppTests {

	@Test
	void contextLoads() {

		//given
		var underTest = new WorkshopResponse();
		//when
		underTest.setStatus(WorkshopResponse.StatusEnum.PENDING);
		//then
		assertThat(underTest).isNotNull();
	}

}
